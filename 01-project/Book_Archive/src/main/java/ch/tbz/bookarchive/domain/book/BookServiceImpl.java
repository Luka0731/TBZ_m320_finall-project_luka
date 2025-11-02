package ch.tbz.bookarchive.domain.book;

import ch.tbz.bookarchive.core.generic.AbstractServiceImpl;
import ch.tbz.bookarchive.domain.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

@Service
public class BookServiceImpl extends AbstractServiceImpl<Book> implements BookService {
    @Autowired
    public BookServiceImpl(BookRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) throws NoSuchElementException {
        Book book = findById(id);

        // remove all likes from users (clear the ManyToMany relationship)
        Set<User> likedByUsers = book.getLikedByUsers();
        for (User user : likedByUsers) {
            user.getLikedBooks().remove(book);
        }
        likedByUsers.clear();

        repository.deleteById(id);
    }
}
