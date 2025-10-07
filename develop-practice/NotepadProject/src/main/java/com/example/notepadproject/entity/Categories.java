package com.example.notepadproject.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private LocalDateTime creat_At;
	
	private LocalDateTime update_At;
	
	public Categories() {
		
	}
	
	public Categories(String name, LocalDateTime creat_At, LocalDateTime update_At) {
		this.name = name;
		this.creat_At = creat_At;
		this.update_At = update_At; 
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDateTime getCreatAt() {
		return creat_At;
	}
	
	public void setCreatAt(LocalDateTime creat_At) {
		this.creat_At = creat_At;
	}
	
	public LocalDateTime getUpdateAt() {
		return update_At;
	}
	
	public void setUpdateAt(LocalDateTime update_At) {
		this.update_At = update_At;
	}
}
