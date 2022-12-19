package com.project.fooddeliveryproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Order_table")
public class Order {

	@Id
	@Column(name="Order_Id")
	@GeneratedValue(generator = "seqO", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="seqO", initialValue = 10)	private long orderId;
	
	@Column(name="Total")
	private float total;
	
	
	@ManyToOne(cascade=CascadeType.MERGE) 
	@JoinColumn(name="userEmailId")
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE)
	private User user;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order(long orderId, float total, User user) {
		super();
		this.orderId = orderId;
		this.total = total;
		this.user = user;
	}
	public Order() {
		
	}
	 
	
}
