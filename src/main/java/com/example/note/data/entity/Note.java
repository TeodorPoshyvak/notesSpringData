package com.example.note.data.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note {
   private Long id;
   private String title;
   private String content;
}
