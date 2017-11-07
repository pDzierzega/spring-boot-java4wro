package com.github.xenteros.service;

import com.github.xenteros.dto.AuthorNoBooksDTO;

import java.util.List;

public interface AuthorService{

    List<AuthorNoBooksDTO> findAllWithoutBooks();

    AuthorNoBooksDTO addAuthor(AuthorNoBooksDTO authorNoBooksDTO);

}
