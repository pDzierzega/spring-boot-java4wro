package com.github.xenteros.mapper;

import com.github.xenteros.dto.BookDTO;
import com.github.xenteros.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring",uses = {AuthorNoBooksMapper.class},unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BookMapper {

    BookDTO toBookDTO(Book book);
    List<BookDTO> toBookDTO(Collection<Book> books);
}
