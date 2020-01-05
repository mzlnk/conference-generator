package pl.mzlnk.conferencegenerator.entity.attendee;

import lombok.AllArgsConstructor;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.Column;
import pl.mzlnk.conferencegenerator.generator.annotations.ForeignKey;
import pl.mzlnk.conferencegenerator.generator.annotations.PrimaryKey;
import pl.mzlnk.conferencegenerator.generator.annotations.Table;

@AllArgsConstructor
@Table(name = "student_attendee")
public class StudentAttendee extends BaseEntity {

    @PrimaryKey
    @ForeignKey
    @Column(name = "attendee_id")
    private int attendeeId;

    @Column(name = "student_card_id")
    private int studentCardId;

}
