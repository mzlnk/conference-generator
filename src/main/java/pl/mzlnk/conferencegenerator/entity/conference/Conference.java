package pl.mzlnk.conferencegenerator.entity.conference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

@Getter
@AllArgsConstructor
@Table(name = "conference")
public class Conference extends BaseEntity {

    @PrimaryKey
    @AutoIncrement
    @Column(name = "conference_id")
    private int conferenceId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
