package com.example.notepadproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notepadproject.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

	Optional<Categories> findByName(String name);
}
