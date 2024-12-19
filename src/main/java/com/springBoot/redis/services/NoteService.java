package com.springBoot.redis.services;

import com.springBoot.redis.entities.Note;
import com.springBoot.redis.repositories.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService {

    @Autowired
    private NoteRepo noteRepo;

    @CachePut(value = "notes", key = "#note.id")
    public Note createNote(Note note) {
        note.setId(UUID.randomUUID().toString());
        return noteRepo.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    @Cacheable(value = "notes", key = "#noteId")
    public Note getById(String noteId) {
        return noteRepo.findById(noteId).orElseThrow(() -> new RuntimeException("Note with given id not found!!"));
    }

    public Note updateNote(String noteId, Note note) {
            Note note1 = noteRepo.findById(noteId).orElseThrow(() -> new RuntimeException("Note with given id not found!!"));
            note1.setTitle(note.getTitle());
            note1.setContent(note.getContent());
            note1.setLive(note.isLive());

        return noteRepo.save(note1);
    }

    @CacheEvict(value = "notes", key = "#noteId")
    public void deleteNote(String noteId) {
        Note note1 = noteRepo.findById(noteId).orElseThrow(() -> new RuntimeException("Note with given id not found!!"));
            noteRepo.delete(note1);
    }


}
