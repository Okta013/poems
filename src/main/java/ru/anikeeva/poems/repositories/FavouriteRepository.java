package ru.anikeeva.poems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anikeeva.poems.entities.Favourite;
import ru.anikeeva.poems.entities.Poem;
import ru.anikeeva.poems.entities.User;

import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository <Favourite, Long> {
    List<Favourite> findByUserId(Long userId);

    void deleteByUserIdAndPoemId(Long userId, Long poemId);
}
