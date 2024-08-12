package ru.anikeeva.poems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anikeeva.poems.entities.Poem;

import java.util.List;
import java.util.Optional;

public interface PoemRepository extends JpaRepository<Poem, Long> {
    List<Poem> findByName(String name);
}
