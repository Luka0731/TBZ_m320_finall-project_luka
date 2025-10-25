package ch.tbz.bookarchive.domain.book;

import ch.tbz.bookarchive.core.generic.AbstractEntity;
import ch.tbz.bookarchive.domain.chapter.Chapter;
import ch.tbz.bookarchive.domain.image.Image;
import ch.tbz.bookarchive.domain.tag.Tag;
import ch.tbz.bookarchive.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
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
    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "is_public", nullable = false)
    private Boolean isPublic;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
//    private User author;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "image_id", referencedColumnName = "id")
//    private Image coverImage;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "book_has_tag", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
//    private Set<Tag> tags;
//
//    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) // todo
//    private List<Chapter> chapters;

    // todo: make it not save:
    //private Integer likeAmount;
}
