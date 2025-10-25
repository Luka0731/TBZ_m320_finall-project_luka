package ch.tbz.bookarchive.domain.tag;

import ch.tbz.bookarchive.core.generic.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Entity
@Table(name = "tag")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Tag extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @Column(name = "tag_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TagType type;
}
