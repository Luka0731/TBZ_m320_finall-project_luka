package ch.tbz.bookarchive.domain.user;

import ch.tbz.bookarchive.core.generic.AbstractServiceImpl;
import ch.tbz.bookarchive.domain.book.Book;
import ch.tbz.bookarchive.domain.book.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {
  private final PasswordEncoder passwordEncoder;
  private final BookRepository bookRepository;

  @Autowired
  public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, BookRepository bookRepository) {
    super(repository);
    this.passwordEncoder = passwordEncoder;
    this.bookRepository = bookRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return ((UserRepository) repository).findByEmail(email)
                                        .map(UserDetailsImpl::new)
                                        .orElseThrow(() -> new UsernameNotFoundException(email));
  }

  @Override
  public User signup(User user) {
    user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
    return save(user);
  }

  @Override
  @Transactional
  public User toggleLikeBook(UUID userId, UUID bookId) {
      User user = findById(userId);
      Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));
      if (user.getLikedBooks().contains(book)) {
          user.getLikedBooks().remove(book);
      } else {
          user.getLikedBooks().add(book);
      }
      return repository.save(user);
  }

  @Override
  @Transactional
  public void deleteById(UUID id) throws NoSuchElementException {
        User user = findById(id);
        // clear all book likes (ManyToMany relationship)
        Set<Book> likedBooks = user.getLikedBooks();
        if (likedBooks != null && !likedBooks.isEmpty()) {
            for (Book book : Set.copyOf(likedBooks)) {
                book.getLikedByUsers().remove(user);
            }
            likedBooks.clear();
        }
        // for each owned book, clear its likes too
        Set<Book> ownedBooks = user.getOwnedBooks();
        if (ownedBooks != null && !ownedBooks.isEmpty()) {
            for (Book book : Set.copyOf(ownedBooks)) {
                // clear likes for this book
                Set<User> likedByUsers = book.getLikedByUsers();
                if (likedByUsers != null && !likedByUsers.isEmpty()) {
                    for (User u : Set.copyOf(likedByUsers)) {
                        u.getLikedBooks().remove(book);
                    }
                    likedByUsers.clear();
                }
            }
        }
        repository.deleteById(id);
    }
}
