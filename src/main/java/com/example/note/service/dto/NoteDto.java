package com.example.note.service.dto;

import lombok.Data;

@Data
public class NoteDto {
    private Long id;
    private String title;
    private String content;
}
