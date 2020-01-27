package com.digiprisma.client.persistence.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author SKAN
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clients")
public class ClientDpo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3445339276682647460L;
	
	@Transient
	public static final String SEQUENCE_NAME = "clients_sequence";
	
	@Id
	private long id;
	private String name;
	private String lastname;
	private Integer phoneNumber;
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	private String adress;
	
	/**
	 * 
	 * @param name
	 * @param lastname
	 * @param phoneNumber
	 * @param birthdate
	 * @param adress
	 */
	public ClientDpo(String name, String lastname, Integer phoneNumber, Date birthdate, String adress) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.birthdate = birthdate;
		this.adress = adress;
	}
	
	
}
