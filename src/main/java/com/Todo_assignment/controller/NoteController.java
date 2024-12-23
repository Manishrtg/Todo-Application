package com.Todo_assignment.controller;

import com.Todo_assignment.dto.NoteDTO;
import com.Todo_assignment.entity.Note;
import com.Todo_assignment.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Create a new note
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody @Valid NoteDTO noteDTO) {
        if (noteDTO.getTitle() == null || noteDTO.getTitle().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Note()); // Return empty note if title is not provided
        }

        Note note = new Note();
        note.setTitle(noteDTO.getTitle());
        note.setDescription(noteDTO.getDescription());
        // No need to manually set 'createdAt' as it's automatically set in the entity.

        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    // Update an existing note by ID
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody @Valid NoteDTO noteDTO) {
        if (noteDTO.getTitle() == null || noteDTO.getTitle().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Note()); // Return empty note if title is not provided
        }

        Note noteDetails = new Note();
        noteDetails.setTitle(noteDTO.getTitle());
        noteDetails.setDescription(noteDTO.getDescription());

        Note updatedNote = noteService.updateNote(id, noteDetails);
        if (updatedNote != null) {
            return ResponseEntity.ok(updatedNote);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if note is not found
        }
    }

    // Get all notes
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    // Get a note by ID
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> note = noteService.getNoteById(id);
        return note.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)); // Return 404 if not found
    }

    // Delete a note by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        boolean isDeleted = noteService.deleteNoteById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
    }
}
