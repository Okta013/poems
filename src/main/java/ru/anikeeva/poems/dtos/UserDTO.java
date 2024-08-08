package ru.anikeeva.poems.dtos;

import lombok.*;
import ru.anikeeva.poems.entities.Poem;
import ru.anikeeva.poems.entities.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private List<Poem> favouritePoems;
    private Collection<Role> roles;
    private List<Poem> createdPoems = new ArrayList<>();
}
