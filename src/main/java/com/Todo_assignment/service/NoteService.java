package com.Todo_assignment.service;

import com.Todo_assignment.entity.Note;
import com.Todo_assignment.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id, Note noteDetails) {
        Optional<Note> existingNote = noteRepository.findById(id);
        if (existingNote.isPresent()) {
            Note note = existingNote.get();
            note.setTitle(noteDetails.getTitle());
            note.setDescription(noteDetails.getDescription());
            return noteRepository.save(note);
        }
        return null; // If note not found, return null
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public boolean deleteNoteById(Long id) {
        Optional<Note> existingNote = noteRepository.findById(id);
        if (existingNote.isPresent()) {
            noteRepository.delete(existingNote.get());
            return true;
        }
        return false; // If note not found, return false
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }
}
