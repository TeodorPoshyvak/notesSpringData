package com.example.note.controller.note;

import com.example.note.service.dto.NoteDto;
import com.example.note.service.mapper.NoteMapper;
import com.example.note.service.service.impl.NoteServiceImpl;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteServiceImpl noteServiceImpl;
    @Autowired
    private NoteMapper noteMapper;

    @GetMapping("/list")
    public ModelAndView getAllNotes(){
        ModelAndView modelAndView = new ModelAndView("notes/allNotes");
        modelAndView.addObject("notes", noteMapper.toNoteResponses(noteServiceImpl.findAll()));
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView getNoteForEdit(@RequestParam(value = "id") Long id){
        NoteDto noteDto = noteServiceImpl.findById(id);
        ModelAndView modelAndView = new ModelAndView("notes/updateNotes");
        modelAndView.addObject("note", noteMapper.toNoteResponse(noteDto));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateNote(
            @RequestParam(value = "id") Long id,
            @Size(min = 3, max = 250) @RequestParam(value = "title") String title,
            @NotEmpty @RequestParam(value = "content") String content){
        NoteDto noteDto = new NoteDto();
        noteDto.setId(id);
        noteDto.setTitle(title);
        noteDto.setContent(content);
        noteServiceImpl.update(noteDto);
        return getAllNotes();
    }

    @PostMapping("/create")
    public ModelAndView createNote(
            @Size(min = 3, max = 250) @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content) {
        NoteDto noteDto = new NoteDto();
        noteDto.setTitle(title);
        noteDto.setContent(content);
        noteServiceImpl.save(noteDto);
        return getAllNotes();
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(@RequestParam(value= "id") Long id){
        noteServiceImpl.delete(id);
        return getAllNotes();
   }
}
