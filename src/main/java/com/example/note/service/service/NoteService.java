package com.example.note.service.service;

import com.example.note.service.dto.NoteDto;
import java.util.List;

public interface NoteService {

    List<NoteDto> findAll();

    NoteDto findById(Long id);

    NoteDto save(NoteDto noteDto);

     void update(NoteDto noteDto);

    void delete(Long id);
}
