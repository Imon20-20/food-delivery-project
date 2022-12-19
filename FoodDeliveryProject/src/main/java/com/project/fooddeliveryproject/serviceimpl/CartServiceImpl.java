package com.project.fooddeliveryproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooddeliveryproject.exception.ResourceNotFoundException;
import com.project.fooddeliveryproject.model.Cart;
import com.project.fooddeliveryproject.model.Food;
import com.project.fooddeliveryproject.model.User;
//import com.project.fooddeliveryproject.model.Category;
//import com.project.fooddeliveryproject.model.Food;
import com.project.fooddeliveryproject.repository.CartRepository;
import com.project.fooddeliveryproject.service.CartService;
import com.project.fooddeliveryproject.service.FoodService;
import com.project.fooddeliveryproject.service.UserService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	private FoodService foodService; 
	private UserService userService; 
	
	public CartServiceImpl(CartRepository cartRepository,FoodService foodService,UserService userService) {
		super();
		this.cartRepository = cartRepository;
		this.foodService =foodService;
		this.userService =userService;
	}

	@Override
	public Cart saveCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getCart() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}

	@Override
	public Cart getCartById(long cartId) {
		// TODO Auto-generated method stub
		return cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart","CartId",cartId)); 
	}

	@Override
	public void deleteCartById(long cartId) {
		// TODO Auto-generated method stub
		cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart","CartId",cartId)); 
		cartRepository.deleteById(cartId);

	}

	@Override
	public Cart addFoodToCart(Cart cart, long foodId,String userEmailId) {
		// TODO Auto-generated method stub
		Food food=foodService.getFoodById(foodId);
		User user=userService.getUserByEmailId(userEmailId);
		cart.setFood(food);
		cart.setUser(user);
		cart.setFoodName(food.getFoodName());
		Cart ecart=cartRepository.findByFoodFoodIdAndUserEmailId(foodId,userEmailId);
		if(ecart==null)
		return cartRepository.save(cart);
		else {
			ecart.setFood(food);
			ecart.setUser(user);
			ecart.setQuantity(ecart.getQuantity()+cart.getQuantity());
			return cartRepository.save(ecart);
		}
	}

	@Override
	public List<Cart> getCartByUserEmailId(String userEmailId) {
		// TODO Auto-generated method stub
		return cartRepository.findByUserEmailId(userEmailId);
		 
	}

	@Override
	public void deleteCartByEmailId(String userEmailId) {
		// TODO Auto-generated method stub
		cartRepository.findByUserEmailId(userEmailId); 
		cartRepository.deleteByUserEmailId(userEmailId);
	}
	
	 
	 
}
