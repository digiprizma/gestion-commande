package com.digiprisma.product.api.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
		@NotNull(message = "Le produit est obligatoire")
		@Valid
		private ProductDto productDto;

}