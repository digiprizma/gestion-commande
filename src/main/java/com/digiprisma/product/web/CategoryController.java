package com.digiprisma.product.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digiprisma.product.api.dto.CategoryRequest;
import com.digiprisma.product.api.dto.CategoryUpdateDto;
import com.digiprisma.product.core.application.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(value = "Categories", tags = "Categories")
@RequestMapping(value = "/api/v0/categories", produces = { MediaType.APPLICATION_JSON_VALUE })
@Slf4j
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	/**
	 * Get all Category
	 *
	 * @return a list of Categorys
	 */
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get all categories")
	public ResponseEntity<?> getCategorys() {
		return ResponseEntity.ok(categoryService.getAllCategories());
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create category")
	public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryRequest request) throws Exception {
		return ResponseEntity.ok(categoryService.createCategory(request));
	}

	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Delete category")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) throws Exception {
		categoryService.deleteCategory(id);
		return ResponseEntity.ok().build();

	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update Category")
	public ResponseEntity<?> updateCategory(@RequestBody @Valid CategoryUpdateDto request) throws Exception {
		return ResponseEntity.ok(categoryService.updateCategory(request));
	}
}
