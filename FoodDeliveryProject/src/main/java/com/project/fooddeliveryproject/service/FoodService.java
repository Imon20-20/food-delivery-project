package com.project.fooddeliveryproject.service;

import java.util.List;



//import javax.validation.Valid;

import com.project.fooddeliveryproject.model.Food;

public interface FoodService {

	Food saveFood( Food food);

	List<Food> getFood();

	Food getFoodById(long foodId);
	List<Food> getFoodByCategoryId(long categoryId);
	Food updateFood(Food food,long foodId);

	void deleteFoodById(long foodId);

	Food addFoodToCategory(Food food, long categoryId);

}
