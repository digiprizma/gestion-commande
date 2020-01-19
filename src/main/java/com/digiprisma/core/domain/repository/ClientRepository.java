package com.digiprisma.core.domain.repository;

import java.util.List;

import com.digiprisma.core.domain.Client;

/**
 * @author mvandenbrande
 */
public interface ClientRepository {

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
