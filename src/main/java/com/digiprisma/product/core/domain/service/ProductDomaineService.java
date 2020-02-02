package com.digiprisma.product.core.domain.service;

import java.util.List;

import com.digiprisma.product.core.domain.Product;

public interface ProductDomaineService {

	/**
	 * Returns all activities.
	 *
	 * @return all activities.
	 */
	List<Product> findAll();

	Product createProduct(Product product);

	void deleteProduct(String idProduct, Long idCategory);

	Product updateProduct(Product product);

	List<Product> findAllByCategory(Long idCategory);
}
