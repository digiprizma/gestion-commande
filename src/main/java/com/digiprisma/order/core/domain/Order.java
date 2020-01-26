package com.digiprisma.order.core.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author SKAN
 *
 */
@Data
@Builder
@Slf4j
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1368245622011496237L;

	private String id;
	private String reference;
	private String client;
	private String product;
	private Date orderDate;
}
