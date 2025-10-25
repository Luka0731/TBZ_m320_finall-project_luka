package ch.tbz.bookarchive.domain.chapter;

import ch.tbz.bookarchive.core.generic.AbstractEntity;
import ch.tbz.bookarchive.domain.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Entity
@Table(name = "chapter")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Chapter extends AbstractEntity {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    private String description;

    @Column(name = "chapter_number", nullable = false)
    private Integer chapterNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book bookId;
}
