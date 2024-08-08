package ru.anikeeva.poems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anikeeva.poems.entities.Poem;

public interface PoemRepository extends JpaRepository<Poem, Integer> {
}
