package ch.tbz.bookarchive.domain.user;

import ch.tbz.bookarchive.core.generic.AbstractService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, AbstractService<User> {
  User signup(User user);
}
