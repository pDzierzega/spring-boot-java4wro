package com.github.xenteros.controller;

import com.github.xenteros.dto.BookDTO;
import com.github.xenteros.dto.NewBookDTO;
import com.github.xenteros.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    BookDTO addBook (@RequestBody NewBookDTO newBookDTO){
        return bookService.addBook(newBookDTO);
    }

}
