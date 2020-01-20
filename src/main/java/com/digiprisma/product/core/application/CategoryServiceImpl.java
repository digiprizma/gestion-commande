package com.digiprisma.product.core.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiprisma.product.api.dto.CategoryDto;
import com.digiprisma.product.api.dto.CategoryRequest;
import com.digiprisma.product.core.application.mapper.CategoryMapper;
import com.digiprisma.product.core.domain.Category;
import com.digiprisma.product.core.domain.service.CategoryDomaineService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author SKAN
 *
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDomaineService categoryDomaineService;
	@Autowired
	private CategoryMapper mapper;

	/*
	 * 
	 */
	@Override
	public List<CategoryDto> getAllCategories() {
		final List<Category> categories = categoryDomaineService.findAll();
		return categories.stream().map(mapper::toTransferObject).collect(Collectors.toList());
	}

	@Override
	public CategoryDto createCategory(CategoryRequest request) {
		CategoryDto categoryDto = request.getCategoryDto();
		Category category = mapper.toDomaineObjectFromDto(categoryDto);
		return mapper.toTransferObject(categoryDomaineService.createCategory(category));
	}

	@Override
	public void deleteCategory(String id) {
		categoryDomaineService.deleteCategory(id);

	}

	@Override
	public CategoryDto updateCategory(CategoryRequest request) {
		CategoryDto CategoryDto = request.getCategoryDto();
		Category Category = mapper.toDomaineObjectFromDto(CategoryDto);
		return mapper.toTransferObject(categoryDomaineService.updateCategory(Category));
	}

}
