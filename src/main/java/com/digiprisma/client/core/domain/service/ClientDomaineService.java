package com.digiprisma.client.core.domain.service;

import java.util.List;

import com.digiprisma.client.core.domain.Client;

public interface ClientDomaineService {

	/**
	 * Returns all activities.
	 *
	 * @return all activities.
	 */
	List<Client> findAll();

	Client createClient(Client client);

	void deleteClient(String id);

	Client updateClient(Client client);
}
