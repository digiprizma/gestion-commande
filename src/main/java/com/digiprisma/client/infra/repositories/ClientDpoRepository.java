package com.digiprisma.client.infra.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.digiprisma.client.persistence.model.ClientDpo;

public interface ClientDpoRepository extends MongoRepository<ClientDpo, Long> {

}
