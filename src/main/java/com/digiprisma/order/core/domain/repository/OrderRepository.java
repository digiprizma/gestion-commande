package com.digiprisma.order.core.domain.repository;

import java.util.List;

import com.digiprisma.order.core.domain.Order;

/**
 * @author mvandenbrande
 */
public interface OrderRepository {

	/**
	 * Returns all activities.
	 *
	 * @return all activities.
	 */
	List<Order> findAll();
    
	
	Order createOrder(Order order);


	void deleteOrder(Long id);


	Order updateOrder(Order order);
}
