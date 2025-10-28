package ch.tbz.bookarchive.domain.user;


import ch.tbz.bookarchive.core.generic.AbstractService;

public interface UserService extends UserDetailsImpl, AbstractService<User> {
  User register(User user);

  User registerUser(User user);
}
