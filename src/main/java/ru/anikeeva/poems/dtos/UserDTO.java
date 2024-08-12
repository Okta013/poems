package ru.anikeeva.poems.dtos;

import lombok.*;
import ru.anikeeva.poems.entities.Poem;
import ru.anikeeva.poems.entities.Role;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private List<Poem> favouritePoems;
    private Set<Role> roles = new HashSet<>();
    private List<Poem> createdPoems = new ArrayList<>();
}
