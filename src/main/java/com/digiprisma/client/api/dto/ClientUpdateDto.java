package com.digiprisma.client.api.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

public class ClientUpdateDto extends ClientDto {

	@ApiModelProperty(accessMode = AccessMode.AUTO )
	private Long id;
}
