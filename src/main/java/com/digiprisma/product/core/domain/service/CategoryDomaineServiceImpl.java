package com.digiprisma.product.core.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiprisma.product.core.domain.Category;
import com.digiprisma.product.core.domain.repository.CategoryRepository;

@Service
public class CategoryDomaineServiceImpl implements CategoryDomaineService {

	@Autowired
	CategoryRepository CategoryRepository;

	@Override
	public List<Category> findAll() {
		return CategoryRepository.findAll();
	}

	@Override
	public Category createCategory(Category category) {
		return CategoryRepository.createCategory(category);
	}

	@Override
	public void deleteCategory(Long id) {
		CategoryRepository.deleteCategory(id);
	}

	@Override
	public Category updateCategory(Category category) {
		return CategoryRepository.updateCategory(category);
	}

	@Override
	public Category findById(Long id) {
		return CategoryRepository.findById(id);
	}

}
