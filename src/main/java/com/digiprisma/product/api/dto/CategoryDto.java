package com.digiprisma.product.api.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author SKAN
 *
 */
@Data
@ApiModel(description = "Category object")
public class CategoryDto {

	@ApiModelProperty(accessMode = AccessMode.READ_ONLY, readOnly = true)
	private Long id;
	@ApiModelProperty(value = "Designation du categorie", allowableValues = "valeur alphabetique", example = "Chambre")
	@NotNull(message = "la designation de categorie est obligatoire")
	private String designation;
}
