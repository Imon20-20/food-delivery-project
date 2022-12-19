package com.project.fooddeliveryproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Category_Table")
public class Category {
	@Id
	@Column(name="Category_Id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator = "seq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="seq", initialValue = 1000)

	private long categoryId;
	
	@Column(name="Category_Name")
	private String categoryName;
    
	@OneToMany(mappedBy="category", cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<Food> food;

	
	public Category()
	{
		
	}


	public Category(long categoryId, String categoryName, List<Food> food) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.food = food;
	}


	public long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public List<Food> getFood() {
		return food;
	}


	public void setFood(List<Food> food) {
		this.food = food;
	}
	
	
	

}
