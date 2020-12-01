package com.digiprisma.product.core.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiprisma.product.core.domain.Category;
import com.digiprisma.product.core.domain.Product;
import com.digiprisma.product.core.domain.repository.ProductRepository;

/**
 * 
 * @author SKAN
 *
 */
@Service
public class ProductDomaineServiceImpl implements ProductDomaineService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryDomaineService categoryDomaineService;

	@Override
	public Product createProduct(Product product) {
		Category category = categoryDomaineService.findById(product.getCategoryId());
		product = productRepository.createProduct(product); 
		category.getProducts().add(product);
		category = categoryDomaineService.updateCategory(category);
		product.setCategoryId(category.getId());
		return product;
	}

	@Override
	public void deleteProduct(String idProduct, Long idCategory) {
		Category category = categoryDomaineService.findById(idCategory);
		List<Product> products = category.getProducts();
		Product productToDelete = products.stream().filter(p -> p.getId().toString().equals(idProduct)).findFirst().orElse(null);
		if(Objects.nonNull(productToDelete)) {
		products.remove(products.indexOf(productToDelete));
		productRepository.deleteProduct(productToDelete.getId()); 
		categoryDomaineService.updateCategory(category);
		} else {
			throw new RuntimeException("cannot delete product   "+ idProduct) ;
		}
	}

	@Override
	public List<Product> findAll() {
		List<Category> categories = categoryDomaineService.findAll();
		List<Product> products = new ArrayList<Product>();
		categories.stream()
		.filter(c -> !c.getProducts().isEmpty())
		.forEach(c -> c.getProducts().stream().forEach(p->p.setCategoryId(c.getId())));
		categories.stream().map(c -> c.getProducts())
		.forEach(list -> products.addAll(list));
		return products;
	}

	@Override
	public Product updateProduct(Product product) {
		Category category = categoryDomaineService.findById(product.getCategoryId());
		Product productToUpadte = category.getProducts().stream().filter(p -> p.getId().equals(product.getId()))
				.findFirst().get();
		category.getProducts().set(category.getProducts().indexOf(productToUpadte), product);
		category = categoryDomaineService.updateCategory(category);
		return product;
	}

	@Override
	public List<Product> findAllByCategory(Long idCategory) {
		Category category = categoryDomaineService.findById(idCategory);
		category.getProducts().stream().forEach(p-> p.setCategoryId(idCategory));
		return  category!= null ? category.getProducts(): null;
	}

}
