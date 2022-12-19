package com.project.fooddeliveryproject.service;

import java.util.List;

import com.project.fooddeliveryproject.model.Cart;
 
public interface CartService {

	Cart saveCart(Cart cart);
	List<Cart> getCart();
	Cart getCartById(long cartId);
	Cart addFoodToCart(Cart cart,long foodId,String userEmailId);
	void deleteCartByEmailId(String userEmailId);
	List<Cart> getCartByUserEmailId(String userEmailId);
	void deleteCartById(long cartId);
}

