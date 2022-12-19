package com.project.fooddeliveryproject.service;

import java.util.List;

import com.project.fooddeliveryproject.model.Order;

public interface OrderService {

	Order saveOrder(Order order,String userEmailId);
	List<Order> getOrder();
	Order getOrderById(long orderId);
	void deleteOrderById(long orderId);
	
	List<Order> getOrderByUserEmailId(String userEmailId);
}
