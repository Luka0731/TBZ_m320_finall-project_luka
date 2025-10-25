package ch.tbz.bookarchive.core.generic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public abstract class AbstractEntity {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(columnDefinition = "uuid", name = "id", updatable = false, nullable = false)
  private UUID id;

  @PostPersist
  protected void onCreate() {
      log.info("Created new entity of type: {}", this.getClass().getSimpleName());
  }

  @PostUpdate
  protected void onUpdate() {
      log.info("Updated entity of type: {} with ID {}", this.getClass().getSimpleName(), id);
  }

  @PostRemove
  protected void onDelete() {
      log.info("Deleted entity of type: {} with ID {}", this.getClass().getSimpleName(), id);
  }
}
