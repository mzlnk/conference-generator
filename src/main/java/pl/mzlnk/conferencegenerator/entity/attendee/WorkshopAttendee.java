package pl.mzlnk.conferencegenerator.entity.attendee;

import lombok.AllArgsConstructor;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

@AllArgsConstructor
@Table(name = "workshop_attendee")
public class WorkshopAttendee extends BaseEntity {

    @PrimaryKey
    @AutoIncrement
    @Column(name = "workshop_attendee_id")
    private int workshopAttendeeId;

    @ForeignKey
    @Column(name = "conference_day_attendee_id")
    private int conferenceDayAttendeeId;

    @ForeignKey
    @Column(name = "workshop_order_item_id")
    private int workshopOrderItemId;

}
