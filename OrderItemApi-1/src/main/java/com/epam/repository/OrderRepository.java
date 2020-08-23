package com.epam.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
