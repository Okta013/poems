package ru.anikeeva.poems.dtos;

import lombok.*;

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
}
