package com.github.xenteros.mapper;

import com.github.xenteros.dto.AuthorNoBooksDTO;
import com.github.xenteros.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AuthorMapper {

    AuthorNoBooksDTO toAuthorNoBooksDTO(Author author);
    List<AuthorNoBooksDTO> toAuthorNoBooksDTO(Collection<Author> authors);
}
