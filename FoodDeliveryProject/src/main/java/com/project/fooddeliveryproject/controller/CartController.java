package com.project.fooddeliveryproject.controller;

import java.util.List;

import javax.validation.Valid;
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
import com.project.fooddeliveryproject.model.Food;
import com.project.fooddeliveryproject.service.CartService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}
	@PostMapping("/add")
	public ResponseEntity<Cart> addCategory(@RequestBody Cart cart)
	{
		return new ResponseEntity<Cart>(cartService.saveCart(cart),HttpStatus.CREATED);
	}

	/*
	 * @PostMapping("/add/{foodId}") public ResponseEntity <Cart>
	 * addFoodToCategory(@Valid @RequestBody Cart cart,@PathVariable("foodId") long
	 * foodId) { return new ResponseEntity<Cart> (cartService.addFoodToCart(cart,
	 * foodId), HttpStatus.CREATED); }
	 */
	@GetMapping
	public List<Cart> getCart()
	{
		return cartService.getCart();
	}
	
	@GetMapping("/user/{userEmailId}")
	public List<Cart> getCartByUserEmailId(@PathVariable("userEmailId") String userEmailId)
	{
		return cartService.getCartByUserEmailId(userEmailId);
	}
	
	@GetMapping("{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable("cartId") long cartId)
	{
		return new ResponseEntity<Cart>(cartService.getCartById(cartId),HttpStatus.OK);
	}
	
	@DeleteMapping("{cartId}")
	public ResponseEntity<String> deleteCart(@PathVariable("cartId") long cartId)
	{
		cartService.deleteCartById(cartId);
		return new ResponseEntity<String>("Cart deleted successfully",HttpStatus.OK);
	}
	@DeleteMapping("/user/{userEmailId}")
	public ResponseEntity<String> deleteCart(@PathVariable("userEmailId") String userEmailId)
	{
		cartService.deleteCartByEmailId(userEmailId);
		return new ResponseEntity<String>("Cart deleted successfully",HttpStatus.OK);
	}
	@PostMapping("/add/{foodId}/{userEmailId}")
	public ResponseEntity <Cart> addFoodToCategory(@Valid @RequestBody Cart cart,@PathVariable("foodId") long foodId,@PathVariable("userEmailId") String userEmailId)
	{
		return new ResponseEntity<Cart> (cartService.addFoodToCart(cart, foodId,userEmailId), HttpStatus.CREATED);
	}
}

