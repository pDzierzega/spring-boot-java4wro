package com.github.xenteros.mapper;

import com.github.xenteros.dto.AuthorDTO;
import com.github.xenteros.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class}
        , unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AuthorMapper {

    AuthorDTO toAuthorDTO(Author author);

    List<AuthorDTO> toAuthorDTO(Collection<Author> author);
}
