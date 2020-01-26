package com.digiprisma.order.persistence.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author SKAN
 *
 */
@Data
@Builder
@Document(collection = "orders")
public class OrderDpo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3445339276682647460L;

	@Id
	private String id;
	private String reference;
	private String client;
	private String product;
	@CreatedDate
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;

}
