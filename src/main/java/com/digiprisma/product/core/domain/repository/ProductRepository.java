package com.digiprisma.product.core.domain.repository;

import java.util.List;

import com.digiprisma.product.core.domain.Product;

/**
 * @author mvandenbrande
 */
public interface ProductRepository {

	/**
	 * Returns all activities.
	 *
	 * @return all activities.
	 */
	List<Product> findAll();

	Product createProduct(Product product);

	void deleteProduct(Long id);

	Product updateProduct(Product product);
}
