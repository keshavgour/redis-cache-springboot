package com.springBoot.redis.repositories;

import com.springBoot.redis.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note, String> {
}
