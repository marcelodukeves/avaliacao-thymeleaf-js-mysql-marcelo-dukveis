package com.senac.crud.controller;

import com.senac.crud.exception.ResourceNotFoundException;
import com.senac.crud.model.Note;
import com.senac.crud.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // 🔹 permite testar com frontend/Thymeleaf sem erro CORS
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    // 🔹 Listar todos
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // 🔹 Criar nova nota
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    // 🔹 Buscar por ID
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
    }

    // 🔹 Atualizar nota existente
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable Long id, @Valid @RequestBody Note noteDetails) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        return noteRepository.save(note);
    }

    // 🔹 Deletar nota
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));

        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}
