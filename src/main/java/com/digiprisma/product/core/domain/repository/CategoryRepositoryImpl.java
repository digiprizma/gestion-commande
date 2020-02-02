package com.digiprisma.product.core.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digiprisma.product.core.application.mapper.CategoryMapper;
import com.digiprisma.product.core.domain.Category;
import com.digiprisma.product.infra.repositories.CategoryDpoRepository;
import com.digiprisma.product.persistence.model.CategoryDpo;
import com.digiprisma.product.persistence.model.ProductDpo;

/**
 * 
 * @author SKAN
 *
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	@Autowired
	CategoryDpoRepository CategoryDpoRepository;
	@Autowired
	CategoryMapper mapper;

	@Override
	public List<Category> findAll() {
		List<CategoryDpo> CategoryDpos = (List<CategoryDpo>) CategoryDpoRepository.findAll();
		return CategoryDpos.stream().map(mapper::toDomaineObject).collect(Collectors.toList());
	}

	@Override
	public Category createCategory(Category Category) {
		CategoryDpo CategoryDpo = CategoryDpoRepository.save(mapper.toDpoObject(Category));
		return mapper.toDomaineObject(CategoryDpo);
	}

	@Override
	public void deleteCategory(Long id) {
		CategoryDpoRepository.deleteById(id);
	}

	@Override
	public Category updateCategory(Category Category) {
		CategoryDpo CategoryDpo = CategoryDpoRepository.save(mapper.toDpoObject(Category));
		return mapper.toDomaineObject(CategoryDpo);
	}

	@Override
	public Category findById(Long id) {
		CategoryDpo categoryDpo = CategoryDpoRepository.findById(id).orElse(null);
		return mapper.toDomaineObject(categoryDpo);
	}

}
