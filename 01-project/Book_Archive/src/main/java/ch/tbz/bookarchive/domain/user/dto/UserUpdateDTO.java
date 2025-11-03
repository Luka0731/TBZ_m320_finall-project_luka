package ch.tbz.bookarchive.domain.user.dto;

import ch.tbz.bookarchive.core.generic.AbstractDTO;
import ch.tbz.bookarchive.domain.book.Book;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class UserUpdateDTO extends AbstractDTO {
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 32, message = "Username must be between 3 and 32 characters")
    private String userName;
}
