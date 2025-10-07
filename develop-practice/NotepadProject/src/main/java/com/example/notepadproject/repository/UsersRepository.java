package com.example.notepadproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notepadproject.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	Optional<Users> findByEmail(String email);
	
	List<Users> findAllByEmail(String email);
}
