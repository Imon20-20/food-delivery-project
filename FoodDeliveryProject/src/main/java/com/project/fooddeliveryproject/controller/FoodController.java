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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import com.project.fooddeliveryproject.model.Food;
import com.project.fooddeliveryproject.service.FoodService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/food")
public class FoodController {

	@Autowired
	private FoodService foodService;

	public FoodController(FoodService foodService) {
		super();
		this.foodService = foodService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Food> addCategory(@Valid @RequestBody Food food)
	{
		return new ResponseEntity<Food>(foodService.saveFood(food),HttpStatus.CREATED);
	}
	@PostMapping("/add/{categoryId}")
	public ResponseEntity <Food> addFoodToCategory(@Valid @RequestBody Food food,@PathVariable("categoryId") long categoryId)
	{
		return new ResponseEntity<Food> (foodService.addFoodToCategory(food, categoryId), HttpStatus.CREATED);
	}
	@GetMapping
	public List<Food> getCategory()
	{
		return foodService.getFood();
	}
	
	@GetMapping("/user/{categoryId}") 
	 public List<Food> getFoodByCategoryId(@PathVariable("categoryId") long  categoryId)
	 {
		 return foodService.getFoodByCategoryId(categoryId); 
	}
	
	@GetMapping("{foodId}")
	public ResponseEntity<Food> getFoodById(@PathVariable("foodId") long foodId)
	{
		return new ResponseEntity<Food>(foodService.getFoodById(foodId),HttpStatus.OK);
	}
	@PutMapping("{foodId}")
	public ResponseEntity<Food> updateFood( @PathVariable("foodId") long foodId, @RequestBody Food food)
	{
		return new ResponseEntity<Food> (foodService.updateFood(food, foodId),HttpStatus.OK);
	}

	@DeleteMapping("{foodId}")
	public ResponseEntity<String> deleteFood(@PathVariable("foodId") long foodId)
	{
		foodService.deleteFoodById(foodId);
		return new ResponseEntity<String>("Food deleted successfully",HttpStatus.OK);
	}
}
