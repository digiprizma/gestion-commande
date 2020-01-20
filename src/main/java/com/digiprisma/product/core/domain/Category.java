package com.digiprisma.product.core.domain;

import java.io.Serializable;

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
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1368245622011496237L;

	private String id;
	private String designation;
}
