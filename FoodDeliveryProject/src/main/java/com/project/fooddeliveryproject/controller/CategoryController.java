package com.project.fooddeliveryproject.controller;

import java.util.List;

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

import com.project.fooddeliveryproject.model.Category;
import com.project.fooddeliveryproject.service.CategoryService;
 
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	 
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
 
	@PostMapping("/add")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)
	{
		return new ResponseEntity<Category>(categoryService.saveCategory(category),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Category> getCategory()
	{
		return categoryService.getCategory();
	}
	
	@GetMapping("{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId") long categoryId)
	{
		return new ResponseEntity<Category>(categoryService.getCategoryById(categoryId),HttpStatus.OK);
	}
	
	@DeleteMapping("{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") long categoryId)
	{
		categoryService.deleteCategoryById(categoryId);
		return new ResponseEntity<String>("Category deleted successfully",HttpStatus.OK);
	}
}	