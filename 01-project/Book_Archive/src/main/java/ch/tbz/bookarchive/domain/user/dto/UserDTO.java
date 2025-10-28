package ch.tbz.bookarchive.domain.user.dto;

import com.example.demo.core.generic.AbstractDTO;
import com.example.demo.domain.listelement.dto.ListElementDTO;
import com.example.demo.domain.role.dto.RoleDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserDTO extends AbstractDTO {
  private String firstName;

  private String lastName;

  @Email
  private String email;

  @Valid
  private Set<RoleDTO> roles;

  private Set<ListElementDTO> listElements;

  public UserDTO(UUID id, String firstName, String lastName, String email, Set<RoleDTO> roles, Set<ListElementDTO> listElements) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.roles = roles;
    this.listElements = listElements;
  }
}
