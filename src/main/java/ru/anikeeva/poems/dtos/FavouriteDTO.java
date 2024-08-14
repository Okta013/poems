package ru.anikeeva.poems.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteDTO {
    private long id;
    private Long userId;
    private Long poemId;
}
