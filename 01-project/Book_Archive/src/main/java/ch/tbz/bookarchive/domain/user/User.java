package ch.tbz.bookarchive.domain.user;

import ch.tbz.bookarchive.core.generic.AbstractEntity;
import ch.tbz.bookarchive.domain.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Log4j2
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class User extends AbstractEntity {
  @Column(name = "user_name", unique = true, nullable = false, length = 32)
  private String userName;

  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @Column(name = "password_hash", nullable = false)
  private String passwordHash;

  @Column(name = "creation_date")
  private LocalDate creationDate;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) // todo
  private Set<Book> ownedBooks = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_liked_book", joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
  private Set<Book> likedBooks = new HashSet<>();
}
