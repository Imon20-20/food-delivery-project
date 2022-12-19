package com.project.fooddeliveryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fooddeliveryproject.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
