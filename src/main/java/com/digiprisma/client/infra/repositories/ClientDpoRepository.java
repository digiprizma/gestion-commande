package com.digiprisma.client.infra.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digiprisma.client.persistence.model.ClientDpo;

@Repository
public interface ClientDpoRepository extends CrudRepository<ClientDpo, String> {
	
}
