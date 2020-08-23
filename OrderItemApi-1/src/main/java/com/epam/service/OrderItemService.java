package com.epam.service;

import java.util.List;

import com.epam.entity.Order;
import com.epam.entity.OrderItem;

public interface OrderItemService {

	public Order createOrderItem(Long id, OrderItem item);

	public List<OrderItem> getOrderItem(Long id);

	public List<OrderItem> getOrderItem(Long orderId, Long id);

}
