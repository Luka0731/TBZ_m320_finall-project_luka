package ch.tbz.bookarchive.domain.book.dto;

import ch.tbz.bookarchive.core.generic.AbstractDTO;
import ch.tbz.bookarchive.domain.chapter.Chapter;
import ch.tbz.bookarchive.domain.tag.Tag;
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
    private String title;

    private String description;

    private Boolean isPublic;

    private UUID authorId;

    private Set<Tag> tagId = new HashSet<>();

    private List<Chapter> chapters = new ArrayList<>();
}
// todo: validation
