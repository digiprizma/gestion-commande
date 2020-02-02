package com.digiprisma.order.infra.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.digiprisma.order.persistence.model.OrderDpo;

@Repository
public interface OrderDpoRepository extends MongoRepository<OrderDpo, Long> {

}
