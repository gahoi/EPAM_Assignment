package com.epam.service;

import java.util.List;

import com.epam.entity.Order;

public interface OrderService {
	
	public Order getOrder(long id);
	
	public Order createOrder(Order order);
	
	public List<Order> getOrders();

}
