package ch.tbz.bookarchive.domain.book;

import ch.tbz.bookarchive.domain.book.dto.BookMapper;
import ch.tbz.bookarchive.domain.book.dto.BookDTO;
import ch.tbz.bookarchive.domain.book.dto.BookRequestDTO;
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
    public ResponseEntity<BookDTO> retrieveById(@PathVariable UUID id) {
        Book book = bookService.findById(id);
        return new ResponseEntity<>(bookMapper.toDTO(book), HttpStatus.OK);
    }

    @GetMapping()
    @Operation(summary = "Show all users", description = "Show all existing users")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<BookDTO>> retrieveAll() {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(bookMapper.toDTOs(books), HttpStatus.OK);
    }

    @PostMapping()
    @Operation(summary = "Create a new book", description = "Create a new book and saves it in the database")
    // @PreAuthorize("hasAuthority('LIST_ELEMENT_CREATE') && @listElementPermissionEvaluator.canCreate(authentication.principal.user, #listElementCreateDTO.getUserId())")
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookRequestDTO bookRequestDTO) {
        Book book = bookService.save(bookMapper.fromBookRequestDTO(bookRequestDTO));
        return new ResponseEntity<>(bookMapper.toDTO(book), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a user by id", description = "Update a certain user by id")
    // @PreAuthorize("hasAuthority('LIST_ELEMENT_MODIFY') and (@listElementPermissionEvaluator.hasRole(authentication.principal.user,'USER') and @listElementPermissionEvaluator.isOwner(authentication.principal.user, #id)) or (@listElementPermissionEvaluator.hasRole(authentication.principal.user,'ADMIN') and @listElementPermissionEvaluator.isNotOwner(authentication.principal.user, #id))")
    public ResponseEntity<BookDTO> updateById(@PathVariable UUID id, @Valid @RequestBody BookRequestDTO bookRequestDTO) {
        Book book = bookService.updateById(id, bookMapper.fromBookRequestDTO(bookRequestDTO));
        return new ResponseEntity<>(bookMapper.toDTO(book), HttpStatus.OK);
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
