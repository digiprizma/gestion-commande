package com.digiprisma.product.api.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author SKAN
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Category object")
public class CategoryDto {

	private String id;
	@ApiModelProperty(value = "Designation du categorie", allowableValues = "valeur alphabetique", example = "Chambre")
	@NotNull(message = "la designation de categorie est obligatoire")
	private String designation;
}
