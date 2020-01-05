package pl.mzlnk.conferencegenerator.entity.attendee;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

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
    @ForeignKey
    @Column(name = "attendee_id")
    private int attendeeId;

    @Column(name = "student_card_id")
    private int studentCardId;

}
