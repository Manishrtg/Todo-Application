package com.Todo_assignment.repository;

import com.Todo_assignment.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}

