package pl.mzlnk.conferencegenerator.model.entity.attendee;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.model.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.Column;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.ForeignKey;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.PrimaryKey;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.Table;

@Getter
@Table(name = "student_attendee")
public class StudentAttendee extends BaseEntity {

    @Builder
    public StudentAttendee(int attendeeId, int studentCardId) {
        super(EntityType.STUDENT_ATTENDEE);

        this.attendeeId = attendeeId;
        this.studentCardId = studentCardId;
    }

    @PrimaryKey
    @ForeignKey(entity = Attendee.class, column = "attendee_id")
    @Column(name = "attendee_id")
    private int attendeeId;

    @Column(name = "student_card_id")
    private int studentCardId;

}
