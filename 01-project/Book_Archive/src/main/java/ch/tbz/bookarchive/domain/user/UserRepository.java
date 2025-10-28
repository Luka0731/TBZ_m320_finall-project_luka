package ch.tbz.bookarchive.domain.user;

import ch.tbz.bookarchive.core.generic.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractRepository<User> {
  Optional<User> findByEmail(String email);
}
