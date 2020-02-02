package com.digiprisma.product.core.domain.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digiprisma.product.core.application.mapper.ProductMapper;
import com.digiprisma.product.core.domain.Product;
import com.digiprisma.product.infra.repositories.ProductDpoRepository;
import com.digiprisma.product.persistence.model.ProductDpo;

/**
 * 
 * @author SKAN
 *
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	ProductDpoRepository ProductDpoRepository;
	@Autowired
	ProductMapper mapper;

	@Override
	public List<Product> findAll() {
		List<ProductDpo> productDpos = (List<ProductDpo>) ProductDpoRepository.findAll();
		return productDpos.stream().map(mapper::toDomaineObject).collect(Collectors.toList());
	}

	@Override
	public Product createProduct(Product Product) {
		ProductDpo productDpo = ProductDpoRepository.save(mapper.toDpoObject(Product));
		return mapper.toDomaineObject(productDpo);
	}

	@Override
	public void deleteProduct(Long id) {
		ProductDpoRepository.deleteById(id);
	}

	@Override
	public Product updateProduct(Product Product) {
		ProductDpo productDpo = ProductDpoRepository.save(mapper.toDpoObject(Product));
		return mapper.toDomaineObject(productDpo);
	}

}
