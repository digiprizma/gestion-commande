package com.digiprisma.product.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
@ApiModel(value = "Product Update Object")
public class ProductUpdateDto extends ProductDto {

	@ApiModelProperty(accessMode = AccessMode.AUTO)
	private Long id;
	
}
