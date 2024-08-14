package ru.anikeeva.poems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.anikeeva.poems.dtos.PoemDTO;
import ru.anikeeva.poems.dtos.UserDTO;
import ru.anikeeva.poems.entities.Poem;
import ru.anikeeva.poems.entities.User;
import ru.anikeeva.poems.repositories.PoemRepository;
import ru.anikeeva.poems.utils.MappingUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PoemService {
    private final PoemRepository poemRepository;
    private final MappingUtils mappingUtils;
    private final UserService userService;

    @Autowired
    public PoemService(PoemRepository poemRepository, MappingUtils mappingUtils, UserService userService) {
        this.poemRepository = poemRepository;
        this.mappingUtils = mappingUtils;
        this.userService = userService;
    }

    public List<PoemDTO> getAllPoems() {
        return poemRepository.findAll().stream().map(mappingUtils::mapToPoemDTO).collect(Collectors.toList());
    }

    public PoemDTO getPoemById(Long id) {
        return poemRepository.findById(id).map(mappingUtils::mapToPoemDTO).orElse(null);
    }

    public List<PoemDTO> getPoemByName(String name) {
        return poemRepository.findByName(name).stream().map(mappingUtils::mapToPoemDTO).collect(Collectors.toList());
    }

    public List<PoemDTO> getPoemByAuthor(String authorName) {
        UserDTO author = userService.findUserByUsername(authorName);
        return new ArrayList<>(author.getCreatedPoems().stream().map(mappingUtils::mapToPoemDTO).toList());
    }

    public PoemDTO createPoem(PoemDTO poemDTO, UserDetails currentUser) {
        Poem poem = mappingUtils.mapToPoem(poemDTO);
        poem.setAuthorId(userService.findUserByUsername(currentUser.getUsername()).getId());
        poemRepository.save(poem);
        return mappingUtils.mapToPoemDTO(poem);
    }

    public PoemDTO updatePoem(Long id, PoemDTO poemDTO) {
        Poem poem = poemRepository.findById(id).orElseThrow(() -> new RuntimeException("Poem not found"));
        poem.setName(poemDTO.getName());
        poem.setContent(poemDTO.getContent());
        poemRepository.save(poem);
        return mappingUtils.mapToPoemDTO(poem);
    }

    public void deletePoem(Long id) {
        poemRepository.deleteById(id);
    }

    public List<PoemDTO> searchPoems(String name, String authorName) {
        if (Optional.ofNullable(name).isPresent()) return getPoemByName(name);
        else if (Optional.ofNullable(authorName).isPresent()) return getPoemByAuthor(authorName);
        else return getAllPoems();
    }


}