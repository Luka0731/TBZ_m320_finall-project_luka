package ch.tbz.bookarchive.domain.book;

import ch.tbz.bookarchive.core.generic.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends AbstractServiceImpl<Book> implements BookService {
    @Autowired
    public BookServiceImpl(BookRepository repository) {
        super(repository);
    }
}
