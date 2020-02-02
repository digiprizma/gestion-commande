package com.digiprisma.order.core.domain.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digiprisma.client.core.application.mapper.ClientMapper;
import com.digiprisma.client.core.domain.Client;
import com.digiprisma.client.infra.repositories.ClientDpoRepository;
import com.digiprisma.client.persistence.model.ClientDpo;
import com.digiprisma.order.core.application.mapper.OrderMapper;
import com.digiprisma.order.core.domain.Order;
import com.digiprisma.order.infra.repositories.OrderDpoRepository;
import com.digiprisma.order.persistence.model.OrderDpo;

/**
 * 
 * @author SKAN
 *
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	OrderDpoRepository orderDpoRepository;
	@Autowired
	OrderMapper mapper;

	@Override
	public List<Order> findAll() {
		List<OrderDpo> orderDpos = (List<OrderDpo>) orderDpoRepository.findAll();
		return orderDpos.stream().map(mapper::toDomaineObject).collect(Collectors.toList());
	}

	@Override
	public Order createOrder(Order order) {
		OrderDpo orderDpo = orderDpoRepository.save(mapper.toDpoObject(order));
		return mapper.toDomaineObject(orderDpo);
	}

	@Override
	public void deleteOrder(Long id) {
		orderDpoRepository.deleteById(id);
	}

	@Override
	public Order updateOrder(Order order) {
		OrderDpo orderDpo = orderDpoRepository.save(mapper.toDpoObject(order));
		return mapper.toDomaineObject(orderDpo);
	}

}
