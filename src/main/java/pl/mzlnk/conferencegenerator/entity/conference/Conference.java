package pl.mzlnk.conferencegenerator.entity.conference;

import lombok.AllArgsConstructor;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.Table;

@AllArgsConstructor
@Table(name = "conference")
public class Conference extends BaseEntity {
}
