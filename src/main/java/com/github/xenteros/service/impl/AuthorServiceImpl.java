package com.github.xenteros.service.impl;

import com.github.xenteros.dto.AuthorDTO;
import com.github.xenteros.dto.AuthorNoBooksDTO;
import com.github.xenteros.exception.AuthorNotFoundException;
import com.github.xenteros.mapper.AuthorMapper;
import com.github.xenteros.mapper.AuthorNoBooksMapper;
import com.github.xenteros.model.Author;
import com.github.xenteros.repositories.AuthorRepository;
import com.github.xenteros.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private AuthorNoBooksMapper authorNoBooksMapper;

    @Override
    public List<AuthorNoBooksDTO> findAllWithoutBooks() {
        return authorNoBooksMapper.toAuthorNoBooksDTO(authorRepository.findAll());
    }

    @Override
    public AuthorNoBooksDTO addAuthor(AuthorNoBooksDTO authorNoBooksDTO) {
        Author author = new Author();
        author.setFirstName(authorNoBooksDTO.getFirstName());
        author.setLastName(authorNoBooksDTO.getLastName());

        author = authorRepository.save(author);

        return authorNoBooksMapper.toAuthorNoBooksDTO(author);
    }

    @Override
    public AuthorDTO findAuthorAndBooks(String authorUuid) {
        Author author = authorRepository
                .findOneByUuid(authorUuid);
        if (author == null) {
            throw new AuthorNotFoundException(authorUuid);
        }
        return authorMapper.toAuthorDTO(author);
    }
}
