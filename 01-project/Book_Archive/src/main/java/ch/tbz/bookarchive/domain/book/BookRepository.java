package ch.tbz.bookarchive.domain.book;

import ch.tbz.bookarchive.core.generic.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends AbstractRepository<Book> {
}
