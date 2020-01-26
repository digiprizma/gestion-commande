package com.digiprisma.order.core.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiprisma.order.core.domain.Order;
import com.digiprisma.order.core.domain.repository.OrderRepository;

@Service
public class OrderDomaineServiceImpl implements OrderDomaineService {

	@Autowired
	OrderRepository OrderRepository;

	@Override
	public List<Order> findAll() {
		return OrderRepository.findAll();
	}

	@Override
	public Order createOrder(Order Order) {
		return OrderRepository.createOrder(Order);
	}

	@Override
	public void deleteOrder(String id) {
		OrderRepository.deleteOrder(id);
	}

	@Override
	public Order updateOrder(Order Order) {
		return OrderRepository.updateOrder(Order);
	}

}
