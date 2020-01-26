package com.digiprisma.product.infra.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digiprisma.product.persistence.model.ProductDpo;

@Repository
public interface ProductDpoRepository extends CrudRepository<ProductDpo, String> {

}
