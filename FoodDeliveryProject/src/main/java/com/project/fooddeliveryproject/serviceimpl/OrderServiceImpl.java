package com.project.fooddeliveryproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooddeliveryproject.exception.ResourceNotFoundException;
import com.project.fooddeliveryproject.model.Cart;
import com.project.fooddeliveryproject.model.Food;
import com.project.fooddeliveryproject.model.Order;
import com.project.fooddeliveryproject.model.User;
import com.project.fooddeliveryproject.repository.OrderRepository;
import com.project.fooddeliveryproject.service.CartService;
import com.project.fooddeliveryproject.service.FoodService;
import com.project.fooddeliveryproject.service.OrderService;
import com.project.fooddeliveryproject.service.UserService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	private CartService cartService;
	private FoodService foodService;
	private UserService userService;
	 
	public OrderServiceImpl(OrderRepository orderRepository, CartService cartService,FoodService foodService,UserService userService) {
		super();
		this.orderRepository = orderRepository;
		this.cartService = cartService;
		this.foodService =foodService;
		this.userService =userService;
	}

	@Override
	public Order saveOrder(Order order,String userEmailId) {
		// TODO Auto-generated method stub
		float total=0.0f;
		User user=userService.getUserByEmailId(userEmailId);
		List<Cart> cartList= cartService.getCartByUserEmailId(userEmailId);
		for(Cart cart:cartList){
			Food food=foodService.getFoodById(cart.getFood().foodId);
			total=total+(food.price*cart.getQuantity());
		}
		order.setTotal(total);
		order.setUser(user);
		Order order1 = orderRepository.findByTotalAndUserEmailId(total,userEmailId);
		if (order1 == null)
			return orderRepository.save(order);
		else 
			return null;
		}
		
	@Override
	public List<Order> getOrder() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(long orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Order","OrderId",orderId));
	}

	
	@Override
	public List<Order> getOrderByUserEmailId(String userEmailId) {
		// TODO Auto-generated method stub
		return orderRepository.findByUserEmailId(userEmailId);
		 
	}
	@Override
	public void deleteOrderById(long orderId) {
		// TODO Auto-generated method stub
		orderRepository.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Order","OrderId",orderId));
		orderRepository.deleteById(orderId);
	}

}
