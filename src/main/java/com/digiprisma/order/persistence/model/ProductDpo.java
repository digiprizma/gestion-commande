package com.digiprisma.order.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDpo {
	private long idProduct;
	private int quantity;
	private double unitPrice;
}
