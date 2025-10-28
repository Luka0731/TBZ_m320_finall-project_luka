package ch.tbz.bookarchive.domain.user.dto;

import ch.tbz.bookarchive.core.generic.AbstractMapper;
import ch.tbz.bookarchive.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends AbstractMapper<User, UserDTO> {
    User fromUserRegisterDTO(UserRegisterDTO dto);
}
