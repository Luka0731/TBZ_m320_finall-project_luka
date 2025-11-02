package ch.tbz.bookarchive.domain.user.dto;

import ch.tbz.bookarchive.core.generic.AbstractDTO;
import ch.tbz.bookarchive.domain.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserDTO extends AbstractDTO {
    private String userName;

    private String email;

    private LocalDate creationDate;

    private Set<UUID> ownedBookIds = new HashSet<>();

    private Set<UUID> likedBookIds = new HashSet<>();
}
// todo: validation
