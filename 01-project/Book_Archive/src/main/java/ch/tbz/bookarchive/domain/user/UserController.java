package ch.tbz.bookarchive.domain.user;

import ch.tbz.bookarchive.domain.user.dto.UserMapper;
import com.example.demo.domain.user.dto.UserDTO;
import com.example.demo.domain.user.dto.UserMapper;
import com.example.demo.domain.user.dto.UserRegisterDTO;
import com.example.demo.domain.user.dto.UserUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService userService;
  private final UserMapper userMapper;

  @Autowired
  public UserController(UserService userService, UserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }

  @GetMapping("/{id}")
  @Operation(summary = "Show a user by id", description = "Find and show a user by id")
  //@PreAuthorize("isAuthenticated()")
  public ResponseEntity<UserDTO> retrieveById(@PathVariable UUID id) {
    User user = userService.findById(id);
    return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
  }

  @GetMapping({"", "/"})
  @Operation(summary = "Show all users", description = "Show all existing users")
  //@PreAuthorize("isAuthenticated()")
  public ResponseEntity<List<UserDTO>> retrieveAll() {
    List<User> users = userService.findAll();
    return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
  }

  @PostMapping("/register")
  @Operation(summary = "Create a new user", description = "Create a new user with a password")
  public ResponseEntity<UserDTO> register(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
    User user = userService.register(userMapper.fromUserRegisterDTO(userRegisterDTO));
    return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
  }
  @PostMapping("/registerUser")
  @Operation(summary = "Create a new user without password", description = "Create a new user without a password or roles and authorities")
  public ResponseEntity<UserDTO> registerWithoutPassword(@Valid @RequestBody UserDTO userDTO) {
    User user = userService.registerUser(userMapper.fromDTO(userDTO));
    return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update a user by id", description = "Update a certain user by id")
  //@PreAuthorize("hasAuthority('USER_MODIFY')")
  public ResponseEntity<UserDTO> updateById(@PathVariable UUID id, @Valid @RequestBody UserUpdateDTO userUpdateDTO) {
    User user = userService.updateById(id, userMapper.fromUserUpdateDTO(userUpdateDTO));
    return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete a user", description = "Delete a certain user by id")
  //@PreAuthorize("hasAuthority('USER_DEACTIVATE')")
  public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
    userService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
