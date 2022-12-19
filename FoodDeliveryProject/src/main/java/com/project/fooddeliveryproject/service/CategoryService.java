package com.project.fooddeliveryproject.service;

import java.util.List;

import com.project.fooddeliveryproject.model.Category;

public interface CategoryService {

	Category saveCategory(Category category);
	List<Category> getCategory();
	Category getCategoryById(long categoryId);
	void deleteCategoryById(long categoryId);
	
}