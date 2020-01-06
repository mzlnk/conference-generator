package pl.mzlnk.conferencegenerator.model.entity.conference;

import lombok.Getter;
import pl.mzlnk.conferencegenerator.model.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.AutoIncrement;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.Column;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.PrimaryKey;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.Table;

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
