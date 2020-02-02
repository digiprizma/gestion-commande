package com.digiprisma.product.core.application;

import java.util.List;

import com.digiprisma.product.api.dto.ProductDto;
import com.digiprisma.product.api.dto.ProductRequest;
import com.digiprisma.product.api.dto.ProductUpdateDto;

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
	List<ProductDto> getAllProducts();
	
	
	List<ProductDto> getProductsByCategory(Long idCategory);

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
	void deleteProduct(String id, Long idCategory);

	/**
	 * 
	 * @param request
	 * @return
	 */
	ProductDto updateProduct(ProductUpdateDto request);
}
