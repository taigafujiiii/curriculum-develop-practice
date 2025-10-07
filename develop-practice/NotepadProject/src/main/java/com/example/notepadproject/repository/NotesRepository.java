package com.example.notepadproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notepadproject.entity.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long> {

}
