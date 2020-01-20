package com.digiprisma.client.api.dto;

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
@ApiModel(description = "Client object")
public class ClientDto {

	private String id;
	@ApiModelProperty(value = "Nom du client", allowableValues = "valeur alphabetique", example = "skander")
    @NotNull(message = "le prenom est obligatoire")
	private String name;
	@ApiModelProperty(value = "Prenom du client", allowableValues = "valeu alphabetique", example = "bachouche")
    @NotNull(message = "le nom est obligatoire")
	private String lastname;
	@ApiModelProperty(value = "Numero telephone", allowableValues = "valeur numérique", example = "22372665")
    @NotNull(message = "le numero de telephone est obligatoire")
	private Integer phoneNumber;
	@ApiModelProperty(value = "Date anniversaire", allowableValues = "date", example = "1988-03-22")
	private Date birthdate;
	@ApiModelProperty(value = "Adresse client", allowableValues = "valeur alphabetique", example = "10 rue kronfol 2063 ben arous")
    @NotNull(message = "l'adresse est obligatoire")
	private String adress;
}
