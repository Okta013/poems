package ru.anikeeva.poems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.anikeeva.poems.dtos.FavouriteDTO;
import ru.anikeeva.poems.dtos.PoemDTO;
import ru.anikeeva.poems.dtos.UserDTO;
import ru.anikeeva.poems.entities.Favourite;
import ru.anikeeva.poems.entities.Poem;
import ru.anikeeva.poems.entities.User;
import ru.anikeeva.poems.repositories.FavouriteRepository;
import ru.anikeeva.poems.utils.MappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavouriteService {
    private final FavouriteRepository favouriteRepository;
    private final UserService userService;
    private final PoemService poemService;
    private final MappingUtils mappingUtils;

    @Autowired
    public FavouriteService(FavouriteRepository favouriteRepository, UserService userService, PoemService poemService, MappingUtils mappingUtils) {
        this.favouriteRepository = favouriteRepository;
        this.userService = userService;
        this.poemService = poemService;
        this.mappingUtils = mappingUtils;
    }

    @Transactional
    public FavouriteDTO addFavouritePoem(Long userId, Long poemId) {
        User user = mappingUtils.mapToUser(userService.findUserById(userId));
        Poem poem = mappingUtils.mapToPoem(poemService.getPoemById(poemId));
        Favourite favourite = new Favourite();
        favourite.setUser(user);
        favourite.setPoem(poem);
        favourite = favouriteRepository.save(favourite);
        return mappingUtils.mapToFavouriteDTO(favourite);
    }

    public List<FavouriteDTO> getFavouritePoems(Long userId) {
        List<Favourite> favouritePoems = favouriteRepository.findByUserId(userId);
        return favouritePoems.stream()
                .map(mappingUtils::mapToFavouriteDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void removeFavouritePoem(Long userId, Long poemId) {
        favouriteRepository.deleteByUserIdAndPoemId(userId, poemId);
    }
}
