package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.access.InvalidInvocationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.Order;
import com.epam.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderServiceController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping(path="/Order",produces="application/json")
	public List<Order> getOrders() {
		return service.getOrders();
	}
	
	
	@GetMapping(path="/Order/{id}")
	public Order getOrder(@PathVariable Long id) {
		if(id == null) {
			throw new InvalidInvocationException("Invalid Input");
		}
		return service.getOrder(id);
	}
	
	@PostMapping(path="/Order")
	public Order createOrder(@RequestBody Order order) {
		return service.createOrder(order);
	}

}
