package ch.tbz.bookarchive.domain.book.dto;

import ch.tbz.bookarchive.core.generic.AbstractDTO;
import ch.tbz.bookarchive.domain.chapter.Chapter;
import ch.tbz.bookarchive.domain.tag.Tag;
import ch.tbz.bookarchive.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BookDTO extends AbstractDTO {
    private String title;

    private String description;

    private LocalDate creationDate;

    private Boolean isPublic;

    private User author;

    private Set<Tag> tags = new HashSet<>();

    private List<Chapter> chapters = new ArrayList<>();
}
// todo: validation

