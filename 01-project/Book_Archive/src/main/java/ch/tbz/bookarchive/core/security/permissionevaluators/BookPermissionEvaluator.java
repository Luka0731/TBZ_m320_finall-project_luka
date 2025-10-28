package ch.tbz.bookarchive.core.security.permissionevaluators;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("bookElementPermissionEvaluator")
@RequiredArgsConstructor
public class BookPermissionEvaluator {
//    private final ListElementRepository listElementRepository;
//
//    public boolean isOwner(User principal, UUID elementId) {
//        return listElementRepository.findById(elementId)
//                .map(listElement -> listElement.getOwner().getId().equals(principal.getId()))
//                .orElse(false);
//    }
//
//    public boolean isNotOwner(User principal, UUID elementId) {
//        return !isOwner(principal, elementId);
//    }
//
//    public boolean canCreate(User principal, UUID targetUserId) {
//        return targetUserId != null && targetUserId.equals(principal.getId());
//    }
//
//    public boolean hasRole(User principal, String roleName) {
//        if (principal == null || roleName == null) {
//            return false;
//        }
//        return principal.getRoles().stream()
//                .anyMatch(role -> roleName.equalsIgnoreCase(role.getName()));
//    }
}
