package ch.tbz.bookarchive.core.security.validators.link;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = LinkValidator.class)
public @interface Link {
  String message() default "{javax.validation.constraints.Link.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
