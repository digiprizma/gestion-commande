package com.digiprisma.product.persistence.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Document(collection = "categories")
@Data
@AllArgsConstructor
@ToString
public class CategoryDpo {

	@Transient
	public static final String SEQUENCE_NAME = "category_sequence";

	@Id
	private long id;
	private String designation;
	@Field("products")
	private List<ProductDpo> products;
	@Transient
	private Map<String, Object> ignoredAttrsWhenSave;

	public CategoryDpo() {
		this.products = new ArrayList<ProductDpo>();
		this.ignoredAttrsWhenSave = new LinkedHashMap<String, Object>();
	}
}