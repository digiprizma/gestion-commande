package com.digiprisma.client.infra.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.digiprisma.client.persistence.model.ClientDpo;

public interface ClientDpoRepository extends MongoRepository<ClientDpo, Long> {

	ClientDpo findByNameAndPhoneNumber(String name, Integer phoneNumber);

}
