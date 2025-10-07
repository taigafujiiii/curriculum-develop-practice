package com.example.notepadproject.config;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.notepadproject.entity.Categories;
import com.example.notepadproject.repository.CategoriesRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	private final CategoriesRepository categoriesRepository;

	public DataInitializer(CategoriesRepository categoriesRepository) {
		this.categoriesRepository = categoriesRepository;
	}

	@Override
	public void run(String... args) {
		List<String> defaultCategories = Arrays.asList("仕事", "プライベート", "その他");
		for (String name : defaultCategories) {
			categoriesRepository.findByName(name).orElseGet(() -> categoriesRepository.save(createCategory(name)));
		}
	}

	private Categories createCategory(String name) {
		LocalDateTime now = LocalDateTime.now();
		Categories category = new Categories();
		category.setName(name);
		category.setCreatAt(now);
		category.setUpdateAt(now);
		return category;
	}
}
