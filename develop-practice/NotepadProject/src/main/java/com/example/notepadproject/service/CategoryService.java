package com.example.notepadproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notepadproject.entity.Categories;
import com.example.notepadproject.repository.CategoriesRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoriesRepository categoriesRepository;
	
	public List<Categories> getAllCategories() {
		return categoriesRepository.findAll();
	}
}
