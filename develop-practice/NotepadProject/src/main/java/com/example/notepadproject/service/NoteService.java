package com.example.notepadproject.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notepadproject.entity.Categories;
import com.example.notepadproject.entity.Notes;
import com.example.notepadproject.entity.Users;
import com.example.notepadproject.repository.CategoriesRepository;
import com.example.notepadproject.repository.NotesRepository;

@Service
public class NoteService {
	
	@Autowired
	private NotesRepository notesRepository;
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	public List<Notes> getAllNotes() {
		return notesRepository.findAll();
	}
	
	public Optional<Notes> getNotesById(Long id) {
		return notesRepository.findById(id);
	}
	
	public Notes createNote(String title, String content, Long categoryId, Users user) {
		Notes note = new Notes();
		note.setTitle(title);
		note.setContent(content);
		note.setCategory(resolveCategory(categoryId));
		note.setCreatedAt(LocalDate.now());
		note.setUser(user);
		return notesRepository.save(note);
	}
	
	public Notes updateNote(Long id, String title, String content, Long categoryId) {
		Notes note = notesRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
		note.setTitle(title);
		note.setContent(content);
		note.setCategory(resolveCategory(categoryId));
		note.setUpdatedAt(LocalDate.now());
		return notesRepository.save(note);
	}
	
	public void deleteNote(Long id) {
		notesRepository.deleteById(id);
	}
	
	private Categories resolveCategory(Long categoryId) {
		if (categoryId == null) {
			return null;
		}
		return categoriesRepository.findById(categoryId).orElse(null);
	}
}
