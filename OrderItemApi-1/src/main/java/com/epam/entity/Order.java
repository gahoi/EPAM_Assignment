package com.epam.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String customerName;
	private String orderDate;
	private String shippingAddress;

	@OneToMany(targetEntity = OrderItem.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "orderItem_fk", referencedColumnName = "id")
	private List<OrderItem> orderItems;
	private int total;

	public String getCustomerName() {
		return customerName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public int getTotal() {
		return total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Order(String customerName, String orderDate, String shippingAddress, int total) {
		super();
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.total = total;
	}

	public Order() {
	}

}
