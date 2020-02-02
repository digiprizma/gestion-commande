package com.digiprisma.product.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digiprisma.product.api.dto.ProductRequest;
import com.digiprisma.product.api.dto.ProductUpdateDto;
import com.digiprisma.product.core.application.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(value = "Products", tags = "Products")
@RequestMapping(value = "/api/v0/", produces = { MediaType.APPLICATION_JSON_VALUE })
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Get all Product
	 *
	 * @return a list of Products
	 */
	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get all products")
	public ResponseEntity<?> getProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create Product")
	public ResponseEntity<?> createProduct(@RequestBody @Valid ProductRequest request) throws Exception {
		return ResponseEntity.ok(productService.createProduct(request));
	}

	@DeleteMapping(value = "/products")
	@ApiOperation(value = "Delete Product")
	public String deleteProduct(@RequestParam String idProduct, @RequestParam Long idCategory) throws Exception {
		productService.deleteProduct(idProduct, idCategory);
		return HttpStatus.OK.toString();

	}
	
	
	@GetMapping(value = "/products/category",params = "idCategory" ,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get Products by category")
	public ResponseEntity<?> getProductsByCategory( @RequestParam("idCategory") Long idCategory) throws Exception {
      return ResponseEntity.ok(productService.getProductsByCategory(idCategory));

	}

	@PutMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update Product")
	public ResponseEntity<?> updateProduct(@RequestBody @Valid ProductUpdateDto request) throws Exception {
		return ResponseEntity.ok(productService.updateProduct(request));
	}
}
