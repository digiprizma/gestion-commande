package com.digiprisma.order.api.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.digiprisma.client.api.dto.ClientDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

	@NotNull(message = "La commande est obligatoire")
	@Valid
	private OrderDto orderDto;
}
