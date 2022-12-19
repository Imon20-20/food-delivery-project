package com.project.fooddeliveryproject.serviceimpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooddeliveryproject.exception.ResourceNotFoundException;
import com.project.fooddeliveryproject.model.Category;
import com.project.fooddeliveryproject.model.Food;
import com.project.fooddeliveryproject.repository.FoodRepository;
import com.project.fooddeliveryproject.service.FoodService;
import com.project.fooddeliveryproject.service.CategoryService;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodRepository foodRepository;
	private CategoryService categoryService;
	 
	
	public FoodServiceImpl(FoodRepository foodRepository, CategoryService categoryService) {
		super();
		this.foodRepository = foodRepository;
		this.categoryService = categoryService;
	}

	@Override
	public Food saveFood(@Valid Food food) {
		// TODO Auto-generated method stub
		 return foodRepository.save(food);
	}

	@Override
	public List<Food> getFood() {
		// TODO Auto-generated method stub
		return foodRepository.findAll()  ;	
		}

	@Override
	public Food getFoodById(long foodId) {
		// TODO Auto-generated method stub
		return foodRepository.findById(foodId).orElseThrow(()->new ResourceNotFoundException("Food","FoodId",foodId)); 
	}

	@Override
	public void deleteFoodById(long foodId) {
		// TODO Auto-generated method stub
		foodRepository.findById(foodId).orElseThrow(()->new ResourceNotFoundException("Food","FoodId",foodId)); 
		foodRepository.deleteById(foodId);
	}

	@Override
	public Food addFoodToCategory(Food food, long categoryId) {
		// TODO Auto-generated method stub
		Category category = categoryService.getCategoryById(categoryId);
		food.setCategory(category);
		return foodRepository.save(food);
	}
	 
	@Override
	public Food updateFood(Food food, long foodId) {
	
		Food existingFood=foodRepository.findById(foodId).orElseThrow(()->new ResourceNotFoundException("Food","FoodId",foodId));	
		existingFood.setFoodName(food.getFoodName());
		existingFood.setPrice(food.getPrice());
		existingFood.setFoodName(food.getFoodName());
		existingFood.setCategory(food.getCategory());
		foodRepository.save(existingFood);
		return existingFood;
		}

	@Override
	public List<Food> getFoodByCategoryId(long categoryId) {
		// TODO Auto-generated method stub
		Category category=categoryService.getCategoryById(categoryId);
		return foodRepository.findByCategoryCategoryId(categoryId); 
	}

	}

