package com.digiprisma.order.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

	private String id;
	@ApiModelProperty(value = "reference de la commade", allowableValues = "valeur alphabetique", example = "ref001")
    @NotNull(message = "la reference est obligatoire")
	private String reference;
	@ApiModelProperty(value = "client", allowableValues = "valeu alphabetique", example = "bachouche")
    @NotNull(message = "le client est obligatoire")
	private String client;
	@ApiModelProperty(value = "produit", allowableValues = "valeur alphabetique", example = "sring")
    @NotNull(message = "le produit est obligatoire")
	private String product;
	@ApiModelProperty(value = "Date de la commande", allowableValues = "date", example = "2020-03-15")
	private Date orderDate;
	
}
