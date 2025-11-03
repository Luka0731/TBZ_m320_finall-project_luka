package ch.tbz.bookarchive.core.security.permissionevaluators;

import ch.tbz.bookarchive.domain.book.BookRepository;
import ch.tbz.bookarchive.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("bookPermissionEvaluator")
@RequiredArgsConstructor
public class BookPermissionEvaluator {
    private final BookRepository bookRepository;

    public boolean isOwner(User principal, UUID elementId) {
        return bookRepository.findById(elementId)
                .map(book -> book.getAuthor().getId().equals(principal.getId()))
                .orElse(false);
    }

    public boolean canCreate(User principal, UUID authorId) {
        return authorId != null && authorId.equals(principal.getId());
    }
}
