package com.digiprisma.order.api.dto;

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
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Order object")
public class OrderUpdateDto extends OrderDto {

	@ApiModelProperty(accessMode = AccessMode.AUTO)
	private Long id;

}
