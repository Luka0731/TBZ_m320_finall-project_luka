package ch.tbz.bookarchive.domain.book.dto;

import ch.tbz.bookarchive.domain.book.Book;
import ch.tbz.bookarchive.core.generic.AbstractMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper extends AbstractMapper<Book, BookDTO> {
    @Override
    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "author.userName", target = "authorName")
    BookDTO toDTO(Book entity);

    @Mapping(source = "authorId", target = "author.id")
    Book fromBookRequestDTO(BookRequestDTO dto);
}
