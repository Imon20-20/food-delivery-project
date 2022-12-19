package com.project.fooddeliveryproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Cart_table")
public class Cart {

	@Id
	@Column(name="Cart_Id")
	@GeneratedValue(generator = "seqC", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="seqC", initialValue = 100)	
	private long cartId;
	
	@Column(name="Quantity")
	private long quantity;
	
	@Column(name="Food_Name")
	private String foodName;
	
	/*
	 * @OneToOne(mappedBy="cart")
	 * 
	 * @JsonIgnore private List<Order> order;
	 */
	

	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="foodId")
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Food food;
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="userEmailId")
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE)
	private User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Cart() {
		
	}
	public Cart(long cartId,long quantity,String foodName,Food food) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.food = food;
		this.foodName=foodName;
	}
	
	
}
