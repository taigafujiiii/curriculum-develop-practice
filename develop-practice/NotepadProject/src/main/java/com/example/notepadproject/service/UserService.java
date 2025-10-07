package com.example.notepadproject.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notepadproject.entity.Users;
import com.example.notepadproject.repository.UsersRepository;

@Service
public class UserService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getUesrsAll() {
		return usersRepository.findAll();
	}
	
	public Users getUserEmail(String email) {
		List<Users> users = usersRepository.findAllByEmail(email);
		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}
	
	public Users createUser(Users user) {
		List<Users> existingUsers = usersRepository.findAllByEmail(user.getEmail());
		if (!existingUsers.isEmpty()) {
			Users existingUser = existingUsers.get(0);
			existingUser.setName(user.getName());
			existingUser.setPassword(user.getPassword());
			existingUser.setUpdateAt(LocalDate.now());
			return usersRepository.save(existingUser);
		}
		LocalDate nowDate = LocalDate.now();
		user.setCreatAt(nowDate);
		user.setUpdateAt(nowDate);
		return usersRepository.save(user);
	}
	

}
