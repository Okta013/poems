package ru.anikeeva.poems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.anikeeva.poems.dtos.PoemDTO;
import ru.anikeeva.poems.services.PoemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/poems")
public class PoemController {
    private final PoemService poemService;

    @Autowired
    public PoemController(PoemService poemService) {
        this.poemService = poemService;
    }

    @PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
    @GetMapping
    public List<PoemDTO> getAllPoems() {
        return poemService.getAllPoems();
    }

    @PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public PoemDTO getPoemById(@PathVariable int id) {
        return poemService.getPoemById(id);
    }

    @PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
    @GetMapping("/search")
    public PoemDTO getPoemByName(@RequestParam String name) {
        return poemService.getPoemByName(name);
    }

    @PostMapping("/new")
    public PoemDTO createPoem(@RequestBody PoemDTO poem) {
        return poemService.createPoem(poem);
    }

    @PutMapping("/{id}")
    public PoemDTO updatePoem(@PathVariable int id, @RequestBody PoemDTO poem) {
        return poemService.updatePoem(id, poem);
    }

    @DeleteMapping("/{id}")
    public void deletePoem(@PathVariable int id) {
        poemService.deletePoem(id);
    }
}
