package com.digiprisma.product.core.application;

import java.util.List;

import com.digiprisma.product.api.dto.CategoryDto;
import com.digiprisma.product.api.dto.CategoryRequest;
import com.digiprisma.product.api.dto.CategoryUpdateDto;

/**
 * 
 * @author SKAN
 *
 */
public interface CategoryService {
	
	CategoryDto getCategoryById(Long id);

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
	void deleteCategory(Long id);

	/**
	 * 
	 * @param request
	 * @return
	 */
	CategoryDto updateCategory(CategoryUpdateDto request);
}
