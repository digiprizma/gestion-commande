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
public class CategoryUpdateDto  extends CategoryDto{
	
	@ApiModelProperty(accessMode = AccessMode.AUTO)
	private Long id;
}
