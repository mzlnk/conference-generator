package pl.mzlnk.conferencegenerator.entity.attendee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

@Getter
@AllArgsConstructor
@Table(name = "conference_day_attendee")
public class ConferenceDayAttendee extends BaseEntity {

    @PrimaryKey
    @AutoIncrement
    @Column(name = "conference_day_attendee_id")
    private int conferenceDayAttendeeId;

    @ForeignKey
    @Column(name = "attendee_id")
    private int attendeeId;

    @ForeignKey
    @Column(name = "conference_day_order_item_id")
    private int conferenceDayOrderItemId;

}
