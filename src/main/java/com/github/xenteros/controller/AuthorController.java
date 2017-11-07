package com.github.xenteros.controller;

import com.github.xenteros.dto.AuthorNoBooksDTO;
import com.github.xenteros.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<AuthorNoBooksDTO> findAll() {
        return authorService.findAllWithoutBooks();

    }

    @PutMapping
    public AuthorNoBooksDTO addAuthor(@RequestBody AuthorNoBooksDTO authorNoBooksDTO){
        return authorService.addAuthor(authorNoBooksDTO);
    }

}
