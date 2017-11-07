package com.github.xenteros.service.impl;


import com.github.xenteros.dto.BookDTO;
import com.github.xenteros.dto.NewBookDTO;
import com.github.xenteros.mapper.BookMapper;
import com.github.xenteros.model.Author;
import com.github.xenteros.model.Book;
import com.github.xenteros.repositories.AuthorRepository;
import com.github.xenteros.repositories.BookRepository;
import com.github.xenteros.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSeriviceImpl implements BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> getBooks() {
        return bookMapper.toBookDTO(bookRepository.findAll());
    }

    @Override
    public BookDTO addBook(NewBookDTO newBookDTO) {
        Author author = authorRepository.findOneByUuid(newBookDTO.getAuthorUuid());
        if (author == null) {
            throw new RuntimeException();
        }
        Book book = new Book();
        book.setTitle(newBookDTO.getTitle());
        book.setAuthor(author);

        book = bookRepository.save(book);
        return bookMapper.toBookDTO(book);
    }

}
