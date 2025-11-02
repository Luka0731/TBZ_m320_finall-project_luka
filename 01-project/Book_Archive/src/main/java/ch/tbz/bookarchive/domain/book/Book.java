package ch.tbz.bookarchive.domain.book;

import ch.tbz.bookarchive.core.generic.AbstractEntity;
import ch.tbz.bookarchive.domain.chapter.Chapter;
import ch.tbz.bookarchive.domain.tag.Tag;
import ch.tbz.bookarchive.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Log4j2
@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Book extends AbstractEntity {
    @Column(nullable = false, length = 64)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "is_public", nullable = false)
    private Boolean isPublic;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_has_tag", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("chapterNumber ASC")
    private List<Chapter> chapters = new ArrayList<>();

    @Formula("(select count(*) from user_likes_book ulb where ulb.book_id = id)")
    private Integer likeAmount;


    // |---- chapter methods ----|

    public Book addChapter(Chapter chapter) {
        if (chapter == null) return this;
        chapters.add(chapter);
        chapter.setBook(this);
        return this;
    }

    public Book removeChapter(Chapter chapter) {
        if (chapter == null) return this;
        if (chapters.remove(chapter)) {
            chapter.setBook(null);
        }
        return this;
    }
}
