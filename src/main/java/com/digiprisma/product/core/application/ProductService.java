package com.digiprisma.product.core.application;

import java.util.List;

import com.digiprisma.product.api.dto.ProductDto;
import com.digiprisma.product.api.dto.ProductRequest;

/**
 * 
 * @author SKAN
 *
 */
public interface ProductService {
	

	/**
	 * Get all Clients
	 * 
	 * @return
	 */
	List<ProductDto> getAllCategories();

	/**
	 * Create Client
	 * 
	 * @param request
	 * @return
	 */
	ProductDto createProduct(ProductRequest request);

	/**
	 * 
	 * @param id
	 */
	void deleteProduct(String id, String idCategory);

	/**
	 * 
	 * @param request
	 * @return
	 */
	ProductDto updateProduct(ProductRequest request);
}
