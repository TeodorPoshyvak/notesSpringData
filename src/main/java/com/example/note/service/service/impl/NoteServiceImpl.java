package com.example.note.service.service.impl;

import com.example.note.data.entity.Note;
import com.example.note.data.repository.NoteRepository;
import com.example.note.service.dto.NoteDto;
import com.example.note.service.mapper.NoteMapper;
import com.example.note.service.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired private NoteRepository noteRepository;
    @Autowired private NoteMapper noteMapper;

    @Override
    public List<NoteDto> findAll() {
        return noteMapper.toNotesDto(noteRepository.findAll());
    }

    @Override
    public NoteDto findById(Long id) {
        return noteMapper.toNoteDto(noteRepository.getReferenceById(id));
    }

    @Override
    public NoteDto save(NoteDto noteDto) {
        Note note = noteMapper.toNoteEntity(noteDto);
        return noteMapper.toNoteDto(noteRepository.save(note));
    }

    @Override
    public void update(NoteDto noteDto) {
            findById(noteDto.getId());
            noteRepository.saveAndFlush(noteMapper.toNoteEntity(noteDto));
    }

    @Override
    public void delete(Long id) {
          findById(id);
          noteRepository.deleteById(id);
    }
}
