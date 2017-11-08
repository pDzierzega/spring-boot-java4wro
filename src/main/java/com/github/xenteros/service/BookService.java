package com.github.xenteros.service;

import com.github.xenteros.dto.BookDTO;
import com.github.xenteros.dto.NewBookAndAuthorDTO;
import com.github.xenteros.dto.NewBookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getBooks();

    BookDTO addBook(NewBookDTO newBookDTO);

    BookDTO addBook(NewBookAndAuthorDTO newBookAndAuthorDTO);
}
