package ru.anikeeva.poems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anikeeva.poems.dtos.PoemDTO;
import ru.anikeeva.poems.entities.Poem;
import ru.anikeeva.poems.repositories.PoemRepository;
import ru.anikeeva.poems.utils.MappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoemService {
    private final PoemRepository poemRepository;
    private final MappingUtils mappingUtils;

    @Autowired
    public PoemService(PoemRepository poemRepository, MappingUtils mappingUtils) {
        this.poemRepository = poemRepository;
        this.mappingUtils = mappingUtils;
    }

    public List<PoemDTO> getAllPoems() {
        return poemRepository.findAll().stream().map(mappingUtils::mapToPoemDTO).collect(Collectors.toList());
    }

    public PoemDTO getPoemById(int id) {
        return poemRepository.findById(id).map(mappingUtils::mapToPoemDTO).orElse(null);
    }

    public PoemDTO createPoem(PoemDTO poemDTO) {
        Poem poem = mappingUtils.mapToPoem(poemDTO);
        poemRepository.save(poem);
        return mappingUtils.mapToPoemDTO(poem);
    }

    public PoemDTO updatePoem(int id, PoemDTO poemDTO) {
        Poem poem = poemRepository.findById(id).orElseThrow(() -> new RuntimeException("Poem not found"));
        poem.setName(poemDTO.getName());
        poem.setContent(poemDTO.getContent());
        poemRepository.save(poem);
        return mappingUtils.mapToPoemDTO(poem);
    }

    public void deletePoem(int id) {
        poemRepository.deleteById(id);
    }
}