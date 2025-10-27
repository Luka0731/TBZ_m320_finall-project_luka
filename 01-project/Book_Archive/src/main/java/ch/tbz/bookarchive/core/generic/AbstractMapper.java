package ch.tbz.bookarchive.core.generic;

import java.util.List;
import java.util.Set;

public interface AbstractMapper<ENTITY extends AbstractEntity, REQUEST_DTO extends AbstractDTO, RESPONSE_DTO extends AbstractDTO> {
  ENTITY fromDTO(REQUEST_DTO dto);

  List<ENTITY> fromDTOs(List<REQUEST_DTO> dtos);

  Set<ENTITY> fromDTOs(Set<REQUEST_DTO> dtos);

  RESPONSE_DTO toDTO(ENTITY BO);

  List<RESPONSE_DTO> toDTOs(List<ENTITY> BOs);

  Set<RESPONSE_DTO> toDTOs(Set<ENTITY> BOs);
}
