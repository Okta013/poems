package ru.anikeeva.poems.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.*;

@Entity
@Table(name="users",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank
    //@Size(min = 3, max = 20)
    @Column(name="username")
    private String username;

    //@NotBlank
    //@Size(min = 6, max = 20)
    @Column(name="password")
    private String password;

//    @Size(min = 3, max = 100)
//    @Column(name="full_name")
    private String fullName;

//    @NotBlank
//    @Size(min = 4, max = 50)
//    @Email
    @Column(name="email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="users_poems",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "poem_id")
    )
    private List<Poem> favouritePoems;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "author_id")
    private List<Poem> createdPoems = new ArrayList<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
