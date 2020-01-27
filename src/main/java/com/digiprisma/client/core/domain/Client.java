package com.digiprisma.client.core.domain;

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
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1368245622011496237L;
	
	private String name;
	private String lastname;
	private Integer phoneNumber;
	private Date birthdate;
	private String adress;
}
