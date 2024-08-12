package ru.anikeeva.poems.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="poems")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Poem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="content")
    private String content;
}
