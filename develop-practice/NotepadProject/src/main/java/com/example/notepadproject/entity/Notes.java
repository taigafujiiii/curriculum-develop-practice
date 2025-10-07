package com.example.notepadproject.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String content;
	
	@ManyToOne
	private Categories category;
	
	@ManyToOne
	private Users user;
	
	private LocalDate created_At;
	
	private LocalDate updated_At;
	
	public Notes() {
		
	}
	
	public Notes(String title, String content, Categories category, Users user, LocalDate created_At, LocalDate updated_At) {
		this.title = title;
		this.content = content;
		this.category = category;
		this.user = user;
		this.created_At = created_At;
		this.updated_At = updated_At;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Categories getCategory() {
		return category;
	}
	
	public void setCategory(Categories category) {
		this.category = category;
	}
	
	public Users getUser() {
		return user;
	}
	
	public void setUser(Users user) {
		this.user = user;
	}
	
	public LocalDate getCreatedAt() {
		return created_At;
	}
	
	public void setCreatedAt(LocalDate created_At) {
		this.created_At = created_At;
	}
	
	public LocalDate getUpdatedAt() {
		return updated_At;
	}
	
	public void setUpdatedAt(LocalDate updated_At) {
		this.updated_At = updated_At;
	}
}
