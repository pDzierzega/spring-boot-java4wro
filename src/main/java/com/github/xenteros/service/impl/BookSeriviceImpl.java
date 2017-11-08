package com.github.xenteros.service.impl;


import com.github.xenteros.dto.BookDTO;
import com.github.xenteros.dto.NewBookAndAuthorDTO;
import com.github.xenteros.dto.NewBookDTO;
import com.github.xenteros.exception.AuthorNotFoundException;
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
            throw new AuthorNotFoundException(newBookDTO.getAuthorUuid());
        }
        Book book = new Book();
        book.setTitle(newBookDTO.getTitle());
        book.setAuthor(author);

        book = bookRepository.save(book);
        return bookMapper.toBookDTO(book);
    }

    @Override
    public BookDTO addBook(NewBookAndAuthorDTO newBookAndAuthorDTO){
        Author author = new Author();
        author.setFirstName(newBookAndAuthorDTO.getFirstName());
        author.setLastName(newBookAndAuthorDTO.getLastName());

        Book book = new Book();
        book.setTitle(newBookAndAuthorDTO.getTitle());
        book.setAuthor(author);

        return bookMapper.toBookDTO(bookRepository.save(book));
    }

}
