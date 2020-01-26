package com.digiprisma.product.api.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Product Object")
public class ProductDto {

	private String id;
	@ApiModelProperty(value = "Designation du Produit", allowableValues = "valeur alphabetique", example = "Lit")
	@NotNull(message = "la designation du Produit est obligatoire")
	private String designation;
	@NotNull(message = "La categorie est obligatoire")
	private String categoryId;
}
