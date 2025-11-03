package ch.tbz.bookarchive.core.security.permissionevaluators;

import ch.tbz.bookarchive.domain.user.User;
import ch.tbz.bookarchive.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("userPermissionEvaluator")
@RequiredArgsConstructor
public class UserPermissionEvaluator {
    private final UserRepository userRepository;

    public boolean isSelf(User principal, UUID userId) {
        return userId != null && userId.equals(principal.getId());
    }
}