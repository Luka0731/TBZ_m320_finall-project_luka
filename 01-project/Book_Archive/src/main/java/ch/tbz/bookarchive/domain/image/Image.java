package ch.tbz.bookarchive.domain.image;

import ch.tbz.bookarchive.core.generic.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Entity
@Table(name = "image")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Image extends AbstractEntity {
    @Column(nullable = false, unique = true, length = 254)
    private String name;

    @Column(nullable = false, length = 254)
    private String type;

    // must be bytea datatype (do NOT use @Lob)
    // otherwise there is a problem with the communication between Hibernate and Postgres driver
    @Column(name = "image_data", length = 1000, nullable = false)
    private byte[] imageData;
}
