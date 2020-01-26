package com.digiprisma.order.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digiprisma.order.api.dto.OrderRequest;
import com.digiprisma.order.core.application.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(value = "Commandes", tags = "Commandes")
@RequestMapping(value = "/api/v0/", produces = { MediaType.APPLICATION_JSON_VALUE })
@Slf4j
public class OrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * Get all Order
	 *
	 * @return a list of Orders
	 */
	@GetMapping(value = "Commandes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get all Orders")
	public ResponseEntity<?> getOrders() {
		return ResponseEntity.ok(orderService.getAllOrders());
	}

	@PostMapping(value = "Commande", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create Order")
	public ResponseEntity<?> createOrder(@RequestBody @Valid OrderRequest request) throws Exception {
		return ResponseEntity.ok(orderService.createOrder(request));
	}

	@DeleteMapping(value = "/Commande")
	@ApiOperation(value = "Delete Order")
	public String deleteOrder(@RequestParam String id) throws Exception {
		orderService.deleteOrder(id);
		return HttpStatus.OK.toString();

	}

	@PutMapping(value = "/Commande", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update Order")
	public ResponseEntity<?> updateOrder(@RequestBody @Valid OrderRequest request) throws Exception {
		return ResponseEntity.ok(orderService.updateOrder(request));
	}
}
