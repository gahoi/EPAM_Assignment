package com.epam.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epam.entity.Order;

@FeignClient(url = "http://localhost:8080/api",name="OrderApi")
@Component
public interface OrderApiProxy {

	@GetMapping("/Order/{id}")
	public Order findById(@PathVariable Long id);
	
	@PostMapping("/Order")
	public Order udpateOrder(@RequestBody Order order);
	
}
