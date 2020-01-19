package com.digiprisma.core.domain.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digiprisma.core.application.mapper.ClientMapper;
import com.digiprisma.core.domain.Client;
import com.digiprisma.infra.repositories.ClientDpoRepository;
import com.digiprisma.persistence.model.ClientDpo;

/**
 * 
 * @author SKAN
 *
 */
@Repository
public class ClientRepositoryImpl implements ClientRepository {

	@Autowired
	ClientDpoRepository clientDpoRepository;
	@Autowired
	ClientMapper mapper;

	@Override
	public List<Client> findAll() {
		List<ClientDpo> clientDpos = (List<ClientDpo>) clientDpoRepository.findAll();
		return clientDpos.stream().map(mapper::toDomaineObject).collect(Collectors.toList());
	}

	@Override
	public Client createClient(Client client) {
		ClientDpo clientDpo = clientDpoRepository.save(mapper.toDpoObject(client));
		return mapper.toDomaineObject(clientDpo);
	}

	@Override
	public void deleteClient(String id) {
		clientDpoRepository.deleteById(id);
	}

	@Override
	public Client updateClient(Client client) {
		ClientDpo clientDpo = clientDpoRepository.save(mapper.toDpoObject(client));
		return mapper.toDomaineObject(clientDpo);
	}

}
