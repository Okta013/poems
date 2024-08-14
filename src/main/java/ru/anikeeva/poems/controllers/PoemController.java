package ru.anikeeva.poems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.anikeeva.poems.dtos.PoemDTO;
import ru.anikeeva.poems.dtos.UserDTO;
import ru.anikeeva.poems.services.FavouriteService;
import ru.anikeeva.poems.services.PoemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/poems")
public class PoemController {
    private final PoemService poemService;
    private final FavouriteService favouriteService;

    @Autowired
    public PoemController(PoemService poemService, FavouriteService favouriteService) {
        this.poemService = poemService;
        this.favouriteService = favouriteService;
    }

    @PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
    @GetMapping
    public List<PoemDTO> getAllPoems() {
        return poemService.getAllPoems();
    }

    @PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public PoemDTO getPoemById(@PathVariable Long id) {
        return poemService.getPoemById(id);
    }

    @PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
    @GetMapping("/search")
    public List<PoemDTO> searchPoems(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String authorName) {
        return poemService.searchPoems(name, authorName);
    }

    @PreAuthorize("hasRole('AUTHOR') or hasRole('ADMIN')")
    @PostMapping("/new")
    public PoemDTO createPoem(@RequestBody PoemDTO poem) {
        return poemService.createPoem(poem);
    }

    @PreAuthorize("hasRole('AUTHOR') or hasRole('ADMIN')")
    @PutMapping("/{id}")
    public PoemDTO updatePoem(@PathVariable Long id, @RequestBody PoemDTO poem) {
        return poemService.updatePoem(id, poem);
    }

    @PreAuthorize("hasRole('AUTHOR') or hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deletePoem(@PathVariable Long id) {
        poemService.deletePoem(id);
    }

    @PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
    @PostMapping("/{id}/favourite")
    public ResponseEntity<String> addFavouritePoem(@PathVariable Long id, @AuthenticationPrincipal UserDetails currentUser) {
        favouriteService.addFavouritePoem(id, currentUser);
        return ResponseEntity.ok("Poem added to favourites");
    }

    @PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
    @DeleteMapping("/{id}/favourite")
    public ResponseEntity<String> removeFavouritePoem(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        favouriteService.removeFavouritePoem(id, userDTO.getId());
        return ResponseEntity.ok("Poem removed from favourites");
    }
}
