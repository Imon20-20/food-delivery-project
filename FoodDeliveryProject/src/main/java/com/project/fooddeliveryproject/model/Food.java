package com.project.fooddeliveryproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "food_table")
public class Food {
	@Id
	@Column(name = "food_Id")
	@GeneratedValue(generator = "seqf", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="seqf", initialValue = 2000)
	public long foodId;
	
	@Column(name = "food_name")
	public String foodName;
	
	@Column(name = "price")
	public float price;
	
	public Food()
	{
		
	}
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="categoryId")
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Category category;

	 

	public Food(long foodId, String foodName, float price, Category category) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
		this.category = category;
	}

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
