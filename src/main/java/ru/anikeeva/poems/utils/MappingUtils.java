package ru.anikeeva.poems.utils;

import org.springframework.stereotype.Component;
import ru.anikeeva.poems.dtos.PoemDTO;
import ru.anikeeva.poems.dtos.RoleDTO;
import ru.anikeeva.poems.dtos.UserDTO;
import ru.anikeeva.poems.entities.Poem;
import ru.anikeeva.poems.entities.Role;
import ru.anikeeva.poems.entities.User;

@Component
public class MappingUtils {
    public UserDTO mapToUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public User mapToUser(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        return user;
    }

    public PoemDTO mapToPoemDTO(Poem poem) {
        PoemDTO dto = new PoemDTO();
        dto.setId(poem.getId());
        dto.setName(poem.getName());
        dto.setContent(poem.getContent());
        return dto;
    }

    public Poem mapToPoem(PoemDTO dto) {
        Poem poem = new Poem();
        poem.setId(dto.getId());
        poem.setName(dto.getName());
        poem.setContent(dto.getContent());
        return poem;
    }

    public RoleDTO mapToRoleDTO(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        return dto;
    }

    public Role mapToRole(RoleDTO dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        return role;
    }
}
