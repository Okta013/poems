package ru.anikeeva.poems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anikeeva.poems.entities.Poem;

import java.util.List;

public interface PoemRepository extends JpaRepository<Poem, Long> {
    List<Poem> findByName(String name);

    List<Poem> findAllByAuthorId(Long authorId);
}
