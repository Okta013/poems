package ru.anikeeva.poems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.anikeeva.poems.dtos.FavouriteDTO;
import ru.anikeeva.poems.dtos.UserDTO;
import ru.anikeeva.poems.services.FavouriteService;
import ru.anikeeva.poems.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final FavouriteService favouriteService;

    @Autowired
    public UserController(UserService userService, FavouriteService favouriteService) {
        this.userService = userService;
        this.favouriteService = favouriteService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> getALLUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @AuthenticationPrincipal UserDetails currentUser) {
        userService.deleteUser(id, currentUser);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/favourites")
    public ResponseEntity<List<FavouriteDTO>> getFavouritePoems(@PathVariable Long id, @AuthenticationPrincipal UserDetails currentUser) {
        List<FavouriteDTO> favouritePoems = favouriteService.getFavouritePoems(id, currentUser);
        return ResponseEntity.ok(favouritePoems);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/activate")
    public ResponseEntity<Void> activateUser(@PathVariable Long id, @AuthenticationPrincipal UserDetails currentUser) {
        userService.activateUser(id);
        return ResponseEntity.noContent().build();
    }

}
