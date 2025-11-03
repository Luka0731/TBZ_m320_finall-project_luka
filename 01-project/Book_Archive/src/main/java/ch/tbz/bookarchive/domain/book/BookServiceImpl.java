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
    public Book updateById(UUID id, Book updatedBook) throws NoSuchElementException {
        Book existingBook = findById(id);
        // update simple fields
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setDescription(updatedBook.getDescription());
        existingBook.setIsPublic(updatedBook.getIsPublic());
        // update tags
        existingBook.getTags().clear();
        if (updatedBook.getTags() != null) {
            existingBook.getTags().addAll(updatedBook.getTags());
        }
        // update chapters
        existingBook.getChapters().clear();
        if (updatedBook.getChapters() != null) {
            for (var chapter : updatedBook.getChapters()) {
                existingBook.addChapter(chapter);
            }
        }
        return repository.save(existingBook);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) throws NoSuchElementException {
        Book book = findById(id);
        Set<User> likedByUsers = book.getLikedByUsers();
        for (User user : likedByUsers) {
            user.getLikedBooks().remove(book);
        }
        likedByUsers.clear();
        repository.deleteById(id);
    }
}
