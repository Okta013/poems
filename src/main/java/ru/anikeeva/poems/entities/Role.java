package ru.anikeeva.poems.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.RoleNotFoundException;

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name= "name", length = 20)
    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }
}
