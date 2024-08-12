package ru.anikeeva.poems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anikeeva.poems.entities.Poem;

import java.util.Optional;

public interface PoemRepository extends JpaRepository<Poem, Integer> {
    Optional<Poem> findByName(String name);
}
