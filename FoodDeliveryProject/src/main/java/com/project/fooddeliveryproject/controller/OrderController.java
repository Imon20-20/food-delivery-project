package com.project.fooddeliveryproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooddeliveryproject.model.Cart;
import com.project.fooddeliveryproject.model.Order;
import com.project.fooddeliveryproject.service.OrderService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@PostMapping("/add/{userEmailId}")
	public ResponseEntity<Order> addOrder(@RequestBody Order order,@PathVariable("userEmailId")String userEmailId)
	{
		System.out.println("In controller"+ order);
		return new ResponseEntity<Order>(orderService.saveOrder(order,userEmailId),HttpStatus.CREATED);
	}
	@GetMapping
	public List<Order> getOrder()
	{
		return orderService.getOrder();
	}
	
	@GetMapping("{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderId") long orderId)
	{
		return new ResponseEntity<Order>(orderService.getOrderById(orderId),HttpStatus.OK);
	}
	
	@GetMapping("/user/{userEmailId}")
	public List<Order> getCartByUserEmailId(@PathVariable("userEmailId") String userEmailId)
	{
		return orderService.getOrderByUserEmailId(userEmailId);
	}
	
	@DeleteMapping("{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable("orderId") long orderId)
	{
		orderService.deleteOrderById(orderId);
		return new ResponseEntity<String>("Order Deleted Successfully",HttpStatus.OK);
	}
}
