package com.digiprisma.order.core.application;

import java.util.List;

import com.digiprisma.order.api.dto.OrderDto;
import com.digiprisma.order.api.dto.OrderRequest;
import com.digiprisma.order.api.dto.OrderUpdateDto;

/**
 * 
 * @author SKAN
 *
 */
public interface OrderService {

	/**
	 * Get all Orders
	 * 
	 * @return
	 */
	List<OrderDto> getAllOrders();

	/**
	 * Create Order
	 * 
	 * @param request
	 * @return
	 */
	OrderDto createOrder(OrderRequest request);

	/**
	 * 
	 * @param id
	 */
	void deleteOrder(Long id);

	/**
	 * 
	 * @param request
	 * @return
	 */
	OrderDto updateOrder(OrderUpdateDto request);
}
