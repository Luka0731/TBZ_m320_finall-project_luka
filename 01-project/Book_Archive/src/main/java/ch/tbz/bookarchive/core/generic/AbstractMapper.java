package ch.tbz.bookarchive.core.generic;

import java.util.List;
import java.util.Set;

public interface AbstractMapper<ENTITY extends AbstractEntity, DTO extends AbstractDTO> {
  ENTITY fromDTO(DTO dto);

  List<ENTITY> fromDTOs(List<DTO> dtos);

  Set<ENTITY> fromDTOs(Set<DTO> dtos);

  DTO toDTO(ENTITY BO);

  List<DTO> toDTOs(List<ENTITY> BOs);

  Set<DTO> toDTOs(Set<ENTITY> BOs);
}
