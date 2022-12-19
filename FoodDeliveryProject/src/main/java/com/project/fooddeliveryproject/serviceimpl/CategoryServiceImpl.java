package com.project.fooddeliveryproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooddeliveryproject.model.Category;
import com.project.fooddeliveryproject.repository.CategoryRepository;
import com.project.fooddeliveryproject.service.CategoryService;
import com.project.fooddeliveryproject.exception.ResourceNotFoundException;
 

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll()  ;
	}

	@Override
	public Category getCategoryById(long categoryId) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId)); 
	}

	@Override
	public void deleteCategoryById(long categoryId) {
		// TODO Auto-generated method stub
		categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId)); 
		categoryRepository.deleteById(categoryId);
	}

	
}
