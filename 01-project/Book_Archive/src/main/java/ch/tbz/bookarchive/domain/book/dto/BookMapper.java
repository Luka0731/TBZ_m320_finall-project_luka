package ch.tbz.bookarchive.domain.book.dto;

import ch.tbz.bookarchive.domain.book.Book;
import ch.tbz.bookarchive.core.generic.AbstractMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper extends AbstractMapper<Book, BookDTO> {
    @Override
    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "author.userName", target = "authorName")
    BookDTO toDTO(Book entity);
}
