package ru.anikeeva.poems.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PoemDTO {
    private Long id;
    private String name;
    private String content;
}
