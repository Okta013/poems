package ru.anikeeva.poems.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/reader")
    @PreAuthorize("hasRole('READER') or hasRole('AUTHOR') or hasRole('ADMIN')")
    public String readerAccess() {
        return "Reader Content.";
    }

    @GetMapping("/author")
    @PreAuthorize("hasRole('AUTHOR')")
    public String authorAccess() {
        return "Author Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}