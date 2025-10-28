package ch.tbz.bookarchive.domain.user.dto;

import com.example.demo.core.generic.AbstractDTO;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserRegisterDTO extends AbstractDTO {
  private String firstName;

  private String lastName;

  @Email
  private String email;

  private String password;

  public UserRegisterDTO(UUID id, String firstName, String lastName, String email, String password) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }
}
