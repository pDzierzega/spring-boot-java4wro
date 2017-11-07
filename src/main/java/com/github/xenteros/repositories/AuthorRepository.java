package com.github.xenteros.repositories;

import com.github.xenteros.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>{

    Author findOneByUuid(String uuid);
}
