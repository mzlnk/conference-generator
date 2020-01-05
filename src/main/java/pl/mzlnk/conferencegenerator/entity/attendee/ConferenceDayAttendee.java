package pl.mzlnk.conferencegenerator.entity.attendee;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

@Getter
@Table(name = "conference_day_attendee")
public class ConferenceDayAttendee extends BaseEntity {

    @Builder
    public ConferenceDayAttendee(int conferenceDayAttendeeId, int attendeeId, int conferenceDayOrderItemId) {
        super(EntityType.CONFERENCE_DAY_ATTENDEE);

        this.conferenceDayAttendeeId = conferenceDayAttendeeId;
        this.attendeeId = attendeeId;
        this.conferenceDayOrderItemId = conferenceDayOrderItemId;
    }

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
