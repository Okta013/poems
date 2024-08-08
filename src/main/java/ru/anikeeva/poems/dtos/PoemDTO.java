package ru.anikeeva.poems.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PoemDTO {
    private int id;
    private String name;
    private String author;
    private String content;
}
