package com.digiprisma.order.core.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiprisma.order.api.dto.OrderDto;
import com.digiprisma.order.api.dto.OrderRequest;
import com.digiprisma.order.api.dto.OrderUpdateDto;
import com.digiprisma.order.core.application.mapper.OrderMapper;
import com.digiprisma.order.core.domain.Order;
import com.digiprisma.order.core.domain.service.OrderDomaineService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDomaineService orderDomaineService;
	@Autowired
	private OrderMapper mapper;

	/*
	 * 
	 */
	@Override
	public List<OrderDto> getAllOrders() {
		final List<Order> orders = orderDomaineService.findAll();
		return orders.stream().map(mapper::toTransferObject).collect(Collectors.toList());
	}

	@Override
	public OrderDto createOrder(OrderRequest request) {
		OrderDto orderDto = request.getOrderDto();
		Order order = mapper.toDomaineObjectFromDto(orderDto);
		return mapper.toTransferObject(orderDomaineService.createOrder(order));
	}

	@Override
	public void deleteOrder(Long id) {
		orderDomaineService.deleteOrder(id);

	}

	@Override
	public OrderDto updateOrder(OrderUpdateDto request) {
		Order order = mapper.toDomaineObjectFromDto(request);
		return mapper.toTransferObject(orderDomaineService.updateOrder(order));
	}

}
