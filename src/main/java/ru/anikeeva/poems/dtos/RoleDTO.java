package ru.anikeeva.poems.dtos;

import lombok.*;
import ru.anikeeva.poems.entities.ERole;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private Integer id;
    private ERole name;
}
