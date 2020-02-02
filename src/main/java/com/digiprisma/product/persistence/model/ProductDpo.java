package com.digiprisma.product.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDpo {

	@Transient
	public static final String SEQUENCE_NAME = "product_sequence";

	@Id
	private long id;
	private String designation;

}