package ch.tbz.bookarchive.domain.book;

import ch.tbz.bookarchive.domain.book.dto.BookMapper;
import ch.tbz.bookarchive.domain.book.dto.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    @Autowired
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Show a book by id", description = "Find and show a book by id")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Book> retrieveById(@PathVariable UUID id) {
        Book book = bookService.findById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping()
    @Operation(summary = "Show all users", description = "Show all existing users")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Book>> retrieveAll() {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping()
    @Operation(summary = "Create a new book", description = "Create a new book and saves it in the database")
    // @PreAuthorize("hasAuthority('LIST_ELEMENT_CREATE') && @listElementPermissionEvaluator.canCreate(authentication.principal.user, #listElementCreateDTO.getUserId())")
    public ResponseEntity<Book> create(@Valid @RequestBody BookDTO bookDTO) {
        Book book = bookService.save(bookMapper.fromDTO(bookDTO));
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a user by id", description = "Update a certain user by id")
    // @PreAuthorize("hasAuthority('LIST_ELEMENT_MODIFY') and (@listElementPermissionEvaluator.hasRole(authentication.principal.user,'USER') and @listElementPermissionEvaluator.isOwner(authentication.principal.user, #id)) or (@listElementPermissionEvaluator.hasRole(authentication.principal.user,'ADMIN') and @listElementPermissionEvaluator.isNotOwner(authentication.principal.user, #id))")
    public ResponseEntity<Book> updateById(@PathVariable UUID id, @Valid @RequestBody BookDTO bookDTO) {
        Book book = bookService.updateById(id, bookMapper.fromDTO(bookDTO));
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user", description = "Delete a certain user by id")
    // @PreAuthorize("hasAuthority('LIST_ELEMENT_DELETE') and (@listElementPermissionEvaluator.hasRole(authentication.principal.user,'USER') and @listElementPermissionEvaluator.isOwner(authentication.principal.user, #id)) or (@listElementPermissionEvaluator.hasRole(authentication.principal.user,'ADMIN') and @listElementPermissionEvaluator.isNotOwner(authentication.principal.user, #id))")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
// todo: security
// todo: filtering
// todo: strategy
