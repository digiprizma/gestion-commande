package com.digiprisma.order.api.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 
 * @author SKAN
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Order object")
public class OrderDto {

	@ApiModelProperty(accessMode = AccessMode.READ_ONLY, readOnly = true)
	private Long id;
	@ApiModelProperty(value = "reference de la commade", allowableValues = "valeur alphabetique", example = "ref001")
    @NotNull(message = "la reference est obligatoire")
	private String reference;
	@ApiModelProperty(value = "client", allowableValues = "valeu numerique", example = "1")
    @NotNull(message = "le client est obligatoire")
	private Long client;
	@ApiModelProperty(value = "products")
    @NotNull(message = "le produit est obligatoire")
	private List<ProductDto> products;
	@ApiModelProperty(value = "Date de la commande", allowableValues = "date", example = "2020-03-15")
	private Date orderDate;
	@ApiModelProperty(value = "total")
	private double total;
	@ApiModelProperty(value = "status")
	// En Attente , En Cours , Terminée, Annulée
	private String status;
	
}
