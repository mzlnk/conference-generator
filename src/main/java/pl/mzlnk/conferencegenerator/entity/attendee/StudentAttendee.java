package pl.mzlnk.conferencegenerator.entity.attendee;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.utils.sql.Column;
import pl.mzlnk.conferencegenerator.utils.sql.ForeignKey;
import pl.mzlnk.conferencegenerator.utils.sql.PrimaryKey;
import pl.mzlnk.conferencegenerator.utils.sql.Table;

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
    @ForeignKey(table = "attendee", column = "attendee_id")
    @Column(name = "attendee_id")
    private int attendeeId;

    @Column(name = "student_card_id")
    private int studentCardId;

}
