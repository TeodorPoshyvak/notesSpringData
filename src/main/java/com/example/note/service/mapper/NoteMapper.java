package com.example.note.service.mapper;

import com.example.note.controller.request.CreateNoteRequest;
import com.example.note.controller.request.UpdateNoteRequest;
import com.example.note.controller.response.NoteResponse;
import com.example.note.data.entity.Note;
import com.example.note.service.dto.NoteDto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteMapper {

    public NoteDto toNoteDto(Note note){
        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setTitle(note.getTitle());
        noteDto.setContent(note.getContent());
        return noteDto;
    }

    public List<NoteDto> toNotesDto(Collection<Note> notes){
        return notes.stream().map(this::toNoteDto).collect(Collectors.toList());
    }

    public  Note toNoteEntity(NoteDto noteDto){
        Note note = new Note();
        note.setId(noteDto.getId());
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        return note;
    }

    public List<Note> toNotesEntity(Collection<NoteDto> notesDto){
        return notesDto.stream().map(this::toNoteEntity).collect(Collectors.toList());
    }

    public NoteResponse toNoteResponse(NoteDto noteDto){
        NoteResponse noteResponse = new NoteResponse();
        noteResponse.setId(noteDto.getId());
        noteResponse.setTitle(noteDto.getTitle());
        noteResponse.setContent(noteDto.getContent());
        return noteResponse;
    }

    public List<NoteResponse> toNoteResponses(Collection<NoteDto> notesDto){
        return notesDto.stream().map(this::toNoteResponse).collect(Collectors.toList());
    }

    public List<NoteDto> requestToNotesDto(Collection<CreateNoteRequest> createNoteRequests){
         return createNoteRequests.stream().map(this::toNoteDto).collect(Collectors.toList());
    }

    public NoteDto toNoteDto(CreateNoteRequest createNoteRequest){
        NoteDto noteDto = new NoteDto();
        noteDto.setTitle(createNoteRequest.getTitle());
        noteDto.setContent(createNoteRequest.getContent());
        return noteDto;
    }

    public NoteDto toNoteDto(Long id, UpdateNoteRequest updateNoteRequest){
        NoteDto noteDto = new NoteDto();
        noteDto.setId(id);
        noteDto.setTitle(updateNoteRequest.getTitle());
        noteDto.setContent(updateNoteRequest.getContent());
        return noteDto;
    }


}
