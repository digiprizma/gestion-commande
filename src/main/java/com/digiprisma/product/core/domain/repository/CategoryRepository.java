package com.digiprisma.product.core.domain.repository;

import java.util.List;

import com.digiprisma.product.core.domain.Category;

/**
 * @author mvandenbrande
 */
public interface CategoryRepository {

	Category findById(Long id);
	
	/**
	 * Returns all activities.
	 *
	 * @return all activities.
	 */
	List<Category> findAll();
    
	
	Category createCategory(Category category);


	void deleteCategory(Long id);


	Category updateCategory(Category category);
}
