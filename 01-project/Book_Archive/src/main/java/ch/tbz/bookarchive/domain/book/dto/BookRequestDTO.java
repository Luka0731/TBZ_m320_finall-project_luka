package ch.tbz.bookarchive.domain.book.dto;

import ch.tbz.bookarchive.core.generic.AbstractDTO;
import ch.tbz.bookarchive.domain.chapter.Chapter;
import ch.tbz.bookarchive.domain.tag.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.*;

@NoArgsConstructor@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BookRequestDTO extends AbstractDTO {
    @NotBlank(message = "Title is required")
    @Size(max = 64, message = "Title must not exceed 64 characters")
    private String title;

    @Size(max = 5000, message = "Description must not exceed 5000 characters")
    private String description;

    @NotNull(message = "Public status is required")
    private Boolean isPublic;

    @NotNull(message = "Author ID is required")
    private UUID authorId;

    @Valid
    private Set<Tag> tags = new HashSet<>();

    @Valid
    private List<Chapter> chapters = new ArrayList<>();
}
