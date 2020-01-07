package pl.mzlnk.conferencegenerator.generator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.model.entity.EntityType;

@Getter
@AllArgsConstructor
abstract class BaseEntityGenerator implements EntityGenerator {

    private EntityType entityType;

}
