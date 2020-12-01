package com.digiprisma.order.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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

	@Transient
	public static final String SEQUENCE_NAME = "order_sequence";

	@Id
	private long id;
	private String reference;
	private long client;
	private List<ProductDpo> products;
	@CreatedDate
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	private double total;
	private String status;

}
