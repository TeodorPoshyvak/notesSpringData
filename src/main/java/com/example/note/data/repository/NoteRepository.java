package com.example.note.data.repository;

import com.example.note.data.entity.Note;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class NoteRepository {
    private List<Note> notes = new ArrayList<>();

    public List<Note> listAll() {
        return this.notes;
    }

    public Note getById(long id) {
        return notes.stream().filter(noteFilter -> noteFilter.getId() == id).findFirst().orElseThrow();
    }
    public Note save(Note note) {
        note.setId(ThreadLocalRandom.current().nextLong());
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        try {
            notes.removeIf(note -> note.getId() == id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void update(Note note) {
        Note updateNote = notes.stream().filter(noteFilter -> noteFilter.getId().equals(note.getId())).findFirst().orElseThrow();
        updateNote.setContent(note.getContent());
        updateNote.setTitle(note.getTitle());
    }

}
