package ru.anikeeva.poems.payload.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Size(min = 3)
    private String fullName;

    @NotBlank
    private boolean isActive;

    @NotBlank
    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
