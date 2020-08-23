package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.OrderItem;
import com.epam.service.OrderItemService;

@RestController
@RequestMapping(path = "/api")
public class OrderItemServiceController {

	@Autowired
	private OrderItemService orderItemService;

	@GetMapping(path = "/Order/{orderid}/OrderItem/{id}", produces = "application/json")
	public List<OrderItem> getOrder(@PathVariable long id, @PathVariable long orderid) {
		return orderItemService.getOrderItem(orderid, id);
	}

	@GetMapping(path = "/Order/{orderid}/OrderItem", produces = "application/json")
	public List<OrderItem> getOrder(@PathVariable long orderid) {
		return orderItemService.getOrderItem(orderid);
	}

	@PostMapping(path = "/Order/{orderid}/OrderItem", consumes = "application/json")
	public void createOrder(@PathVariable long orderid, @RequestBody OrderItem orderItem) {
		orderItemService.createOrderItem(orderid, orderItem);
	}

}
