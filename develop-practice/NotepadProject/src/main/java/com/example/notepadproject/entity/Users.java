package com.example.notepadproject.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private LocalDate creat_At;
	
	private LocalDate update_At;
	
	public Users() {
		
	}
	
	public Users(String name, String email, String password, LocalDate creat_At, LocalDate update_At) {
		this.name = name;
		this.email = email;
		this.password = password;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LocalDate getCreatAt() {
		return creat_At;
	}
	
	public void setCreatAt(LocalDate creat_At) {
		this.creat_At = creat_At;
	}
	
	public LocalDate getUpdateAt() {
		return update_At;
	}
	
	public void setUpdateAt(LocalDate update_At) {
		this.update_At = update_At;
	}
}
