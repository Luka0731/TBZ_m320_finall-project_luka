package ch.tbz.bookarchive.domain.user.dto;

import ch.tbz.bookarchive.core.generic.AbstractMapper;
import ch.tbz.bookarchive.domain.book.Book;
import ch.tbz.bookarchive.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends AbstractMapper<User, UserDTO> {
    @Mapping(source = "password", target = "passwordHash")
    User fromUserRegisterDTO(UserSignupDTO dto);

    @Override
    @Mapping(source = "ownedBooks", target = "ownedBookIds", qualifiedByName = "booksToIds")
    @Mapping(source = "likedBooks", target = "likedBookIds", qualifiedByName = "booksToIds")
    UserDTO toDTO(User entity);

    @Named("booksToIds")
    default Set<UUID> booksToIds(Set<Book> books) {
        if (books == null) {
            return Set.of();
        }
        return books.stream()
                .map(Book::getId)
                .collect(Collectors.toSet());
    }
}
