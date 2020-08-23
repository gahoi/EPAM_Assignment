package com.epam.srvcImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Order;
import com.epam.exceptionHandling.OrderNotFoundException;
import com.epam.repository.OrderRepository;
import com.epam.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repository;

	@Override
	public Order getOrder(long id) {
		// TODO Auto-generated method stub
		if(!repository.findById(id).isPresent()) {
			throw new OrderNotFoundException("order "+id+" is not found");
		}else {
			return repository.findById(id).get();
		}
		
	}

	@Override	
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return repository.save(order);
		
	}

	@Override
	public List<Order> getOrders() {
		
		List<Order> orderList = new ArrayList<Order>();
		// TODO Auto-generated method stub
		repository.findAll().forEach(i -> orderList.add(i));
		return orderList;
	}

}
