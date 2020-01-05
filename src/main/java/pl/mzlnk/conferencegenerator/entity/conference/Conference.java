package pl.mzlnk.conferencegenerator.entity.conference;

import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

@Getter
@Table(name = "conference")
public class Conference extends BaseEntity {

    public Conference(int conferenceId, String name, String description) {
        super(EntityType.CONFERENCE);

        this.conferenceId = conferenceId;
        this.name = name;
        this.description = description;
    }

    @PrimaryKey
    @AutoIncrement
    @Column(name = "conference_id")
    private int conferenceId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
