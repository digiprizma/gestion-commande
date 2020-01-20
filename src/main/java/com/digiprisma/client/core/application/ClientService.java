package com.digiprisma.client.core.application;

import java.util.List;

import com.digiprisma.client.api.dto.ClientDto;
import com.digiprisma.client.api.dto.ClientRequest;

/**
 * 
 * @author SKAN
 *
 */
public interface ClientService {

	/**
	 * Get all Clients
	 * 
	 * @return
	 */
	List<ClientDto> getAllClients();

	/**
	 * Create Client
	 * 
	 * @param request
	 * @return
	 */
	ClientDto createClient(ClientRequest request);

	/**
	 * 
	 * @param id
	 */
	void deleteClient(String id);

	/**
	 * 
	 * @param request
	 * @return
	 */
	ClientDto updateClient(ClientRequest request);
}
