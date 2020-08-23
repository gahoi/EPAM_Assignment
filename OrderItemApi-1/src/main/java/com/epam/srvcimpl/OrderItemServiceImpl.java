package com.epam.srvcimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Order;
import com.epam.entity.OrderItem;
import com.epam.exceptionHandling.OrderItemNotFound;
import com.epam.feignClients.OrderApiProxy;
import com.epam.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	public OrderApiProxy orderApi;

	@Override
	public Order createOrderItem(Long orderId, OrderItem item) {
		// TODO Auto-generated method stub
		Order order = orderApi.findById(orderId);
		List<OrderItem> orderItem = order.getOrderItems();
		orderItem.add(item);
		order.setOrderItems(orderItem);
		Order orderSaved = orderApi.udpateOrder(order);
		return orderSaved;
	}

	@Override
	public List<OrderItem> getOrderItem(Long orderId) {
		// TODO Auto-generated method stub
		return orderApi.findById(orderId).getOrderItems();
	}

	@Override
	public List<OrderItem> getOrderItem(Long orderId, Long id) {
		// TODO Auto-generated method stub
		if(orderApi.findById(orderId).getOrderItems().stream().noneMatch(item -> item.getId() == id)) {
			throw new OrderItemNotFound("Order Item " + id + " not found");
		}
		
		return orderApi.findById(orderId).getOrderItems().stream().filter(item -> item.getId() == id)
				.collect(Collectors.toList());
	}

}
