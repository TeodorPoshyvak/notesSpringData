package com.example.note.controller.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class NoteRequest {

    @Size(min = 3, max = 250)
    String title;

    @NotEmpty
    String content;
}
