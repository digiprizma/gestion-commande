package com.digiprisma.order.infra.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digiprisma.order.persistence.model.OrderDpo;

@Repository
public interface OrderDpoRepository extends CrudRepository<OrderDpo, String> {

}
