package com.digiprisma.client.core.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiprisma.client.core.domain.Client;
import com.digiprisma.client.core.domain.repository.ClientRepository;

@Service
public class ClientDomaineServiceImpl implements ClientDomaineService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client createClient(Client client) {
		return clientRepository.createClient(client);
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteClient(id);
	}

	@Override
	public Client updateClient(Client client) {
		return clientRepository.updateClient(client);
	}

}
