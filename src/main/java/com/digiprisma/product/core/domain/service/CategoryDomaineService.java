package com.digiprisma.product.core.domain.service;

import java.util.List;

import com.digiprisma.product.core.domain.Category;

public interface CategoryDomaineService {

	/**
	 * Returns all activities.
	 *
	 * @return all activities.
	 */
	List<Category> findAll();

	Category createCategory(Category category);

	void deleteCategory(String id);

	Category updateCategory(Category category);
}
