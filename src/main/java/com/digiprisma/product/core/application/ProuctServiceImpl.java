package com.digiprisma.product.core.application;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiprisma.product.api.dto.CategoryDto;
import com.digiprisma.product.api.dto.ProductDto;
import com.digiprisma.product.api.dto.ProductRequest;
import com.digiprisma.product.api.dto.ProductUpdateDto;
import com.digiprisma.product.core.application.mapper.CategoryMapper;
import com.digiprisma.product.core.application.mapper.ProductMapper;
import com.digiprisma.product.core.domain.Category;
import com.digiprisma.product.core.domain.Product;
import com.digiprisma.product.core.domain.service.ProductDomaineService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author SKAN
 *
 */
@Service
@Slf4j
public class ProuctServiceImpl implements ProductService {

	@Autowired
	private ProductDomaineService productDomaineService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductMapper mapper;
	@Autowired
	private CategoryMapper categoryMapper;

	/*
	 * 
	 */
	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> products = productDomaineService.findAll();
		return products.stream().map(mapper::toTransferObject).collect(Collectors.toList());
	}

	@Override
	public ProductDto createProduct(ProductRequest request) {
		ProductDto productDto = request.getProductDto();
		CategoryDto categoryDto = categoryService.getCategoryById(productDto.getCategoryId());
		Category category = categoryMapper.toDomaineObjectFromDto(categoryDto);
		if (category == null) {
			throw new RuntimeException("Categorie is null");
		}
		Product product = mapper.toDomaineObjectFromDto(productDto);
		Product productCreated = productDomaineService.createProduct(product);
		return mapper.toTransferObject(productCreated);
	}

	@Override
	public void deleteProduct(String idProduct, Long idCategory) {
		CategoryDto categoryDto = categoryService.getCategoryById(idCategory);
		productDomaineService.deleteProduct(idProduct, idCategory);

	}

	@Override
	public ProductDto updateProduct(ProductUpdateDto request) {

		CategoryDto categoryDto = categoryService.getCategoryById(request.getCategoryId());
		Category category = categoryMapper.toDomaineObjectFromDto(categoryDto);
		if (category == null) {
			throw new RuntimeException("Categorie is null");
		}
		Product product = mapper.toDomaineObjectFromDto(request);
		Product productUpdated = productDomaineService.updateProduct(product);
		return mapper.toTransferObject(productUpdated);
	}

	@Override
	public List<ProductDto> getProductsByCategory(Long idCategory) {
		List<Product> products = productDomaineService.findAllByCategory(idCategory);
		return products != null ? products.stream().map(mapper::toTransferObject).collect(Collectors.toList())
				: Collections.EMPTY_LIST;
	}

}
