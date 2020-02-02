package com.digiprisma.product.infra.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digiprisma.product.persistence.model.CategoryDpo;

@Repository
public interface CategoryDpoRepository extends MongoRepository<CategoryDpo, Long> {

}
