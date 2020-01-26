package com.digiprisma.order.core.domain.service;

import java.util.List;

import com.digiprisma.order.core.domain.Order;

public interface OrderDomaineService {

	/**
	 * Returns all activities.
	 *
	 * @return all activities.
	 */
	List<Order> findAll();

	Order createOrder(Order Order);

	void deleteOrder(String id);

	Order updateOrder(Order Order);
}
