package com.digiprisma.infra.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digiprisma.persistence.model.ClientDpo;

@Repository
public interface ClientDpoRepository extends CrudRepository<ClientDpo, String> {
	
}
