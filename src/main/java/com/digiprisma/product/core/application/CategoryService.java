package com.digiprisma.product.core.application;

import java.util.List;

import com.digiprisma.product.api.dto.CategoryDto;
import com.digiprisma.product.api.dto.CategoryRequest;

/**
 * 
 * @author SKAN
 *
 */
public interface CategoryService {
	
	CategoryDto getCategoryById(String id);

	/**
	 * Get all Clients
	 * 
	 * @return
	 */
	List<CategoryDto> getAllCategories();

	/**
	 * Create Client
	 * 
	 * @param request
	 * @return
	 */
	CategoryDto createCategory(CategoryRequest request);

	/**
	 * 
	 * @param id
	 */
	void deleteCategory(String id);

	/**
	 * 
	 * @param request
	 * @return
	 */
	CategoryDto updateCategory(CategoryRequest request);
}
