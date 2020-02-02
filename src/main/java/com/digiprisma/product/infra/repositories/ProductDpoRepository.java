package com.digiprisma.product.infra.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.digiprisma.product.persistence.model.ProductDpo;

@Repository
public interface ProductDpoRepository extends MongoRepository<ProductDpo, Long> {

}
