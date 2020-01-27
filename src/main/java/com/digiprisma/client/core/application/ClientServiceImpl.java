package com.digiprisma.client.core.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiprisma.client.api.dto.ClientDto;
import com.digiprisma.client.api.dto.ClientRequest;
import com.digiprisma.client.core.domain.Client;
import com.digiprisma.client.core.application.mapper.ClientMapper;
import com.digiprisma.client.core.domain.service.ClientDomaineService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDomaineService clientDomaineService;
	@Autowired
	private ClientMapper mapper;

	/*
	 * 
	 */
	@Override
	public List<ClientDto> getAllClients() {
		final List<Client> clients = clientDomaineService.findAll();
		return clients.stream().map(mapper::toTransferObject).collect(Collectors.toList());
	}

	@Override
	public ClientDto createClient(ClientRequest request) {
		ClientDto clientDto = request.getClientDto();
		Client client = mapper.toDomaineObjectFromDto(clientDto);
		return mapper.toTransferObject(clientDomaineService.createClient(client));
	}

	@Override
	public void deleteClient(Long id) {
		clientDomaineService.deleteClient(id);

	}

	@Override
	public ClientDto updateClient(ClientRequest request) {
		ClientDto clientDto = request.getClientDto();
		Client client = mapper.toDomaineObjectFromDto(clientDto);
		return mapper.toTransferObject(clientDomaineService.updateClient(client));
	}

}
