package com.example.notepadproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.notepadproject.entity.Categories;
import com.example.notepadproject.entity.Notes;
import com.example.notepadproject.entity.Users;
import com.example.notepadproject.service.CategoryService;
import com.example.notepadproject.service.NoteService;
import com.example.notepadproject.service.UserService;

@Controller
public class NotepadController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private CategoryService categoryService;
	// ルートURL（/）にアクセスされたらログインページへリダイレクト
	@GetMapping("/")
	public String redirectToLogin() {
			return "redirect:/registration";
	}

	@GetMapping("/registration")
	public String getRegistration() {
		return "registration";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";	
	}
	
	@PostMapping
	public String postLogin() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String getHome(Authentication user, Model model) {
		List<Notes> noteList = noteService.getAllNotes();
		model.addAttribute("notes", noteList);
		return "home";	
	}
	
	@GetMapping("/show")
	public String getShow(@RequestParam("id") Long id, Authentication user, Model model) {
		Optional<Notes> note = noteService.getNotesById(id);
		Users loginUser = userService.getUserEmail(user.getName());
		String userName = loginUser != null ? loginUser.getName() : "";
		model.addAttribute("notes", note.get());
		model.addAttribute("userName", userName);
		return "show";	
	}
	
	@GetMapping("/create")
	public String getCreate(Model model) {
		List<Categories> categoryList = categoryService.getAllCategories();
		model.addAttribute("categories", categoryList);
		return "create";	
	}
	
	@GetMapping("/edit")
	public String getEdit(@RequestParam("id") Long id, Model model) {
		Optional<Notes> note = noteService.getNotesById(id);
		List<Categories> categoryList = categoryService.getAllCategories();
		model.addAttribute("notes", note.get());
		model.addAttribute("categories", categoryList);
		return "edit";	
	}
	
	@PostMapping("/addUser")
	public String createUser(Users user, Model model) {
		userService.createUser(user);
		return "redirect:/login";	
	}
	
	@PostMapping("/add")
	public String createNote(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam(value = "categoryId", required = false) String categoryId,
			Authentication user) {
		if (user == null || user.getName() == null) {
			return "redirect:/home";
		}
		Users loginUser = userService.getUserEmail(user.getName());
		if (loginUser == null) {
			return "redirect:/home";
		}
		noteService.createNote(title, content, parseCategoryId(categoryId), loginUser);
		return "redirect:/home";
	}
	
	@PutMapping("/update")
	public String updateNote(
			@RequestParam("id") Long id,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam(value = "categoryId", required = false) String categoryId) {
		noteService.updateNote(id, title, content, parseCategoryId(categoryId));
		return "redirect:/home";
	}
	
	private Long parseCategoryId(String categoryId) {
		if (categoryId == null || categoryId.isBlank()) {
			return null;
		}
		try {
			return Long.valueOf(categoryId);
		} catch (NumberFormatException ex) {
			return null;
		}
	}
	
	@DeleteMapping("/delete")
	public String deleteNote(@RequestParam("id") Long id) {
		noteService.deleteNote(id);
		return "redirect:/home";
	}

}
