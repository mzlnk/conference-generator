package pl.mzlnk.conferencegenerator.entity.attendee;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.utils.sql.*;

@Getter
@Table(name = "workshop_attendee")
public class WorkshopAttendee extends BaseEntity {

    @Builder
    public WorkshopAttendee(int workshopAttendeeId, int conferenceDayAttendeeId, int workshopOrderItemId) {
        super(EntityType.WORKSHOP_ATTENDEE);

        this.workshopAttendeeId = workshopAttendeeId;
        this.conferenceDayAttendeeId = conferenceDayAttendeeId;
        this.workshopOrderItemId = workshopOrderItemId;
    }

    @PrimaryKey
    @AutoIncrement
    @Column(name = "workshop_attendee_id")
    private int workshopAttendeeId;

    @ForeignKey(table = "conference_day_attendee", column = "conference_day_attendee_id")
    @Column(name = "conference_day_attendee_id")
    private int conferenceDayAttendeeId;

    @ForeignKey(table = "workshop_order_item", column = "workshop_order_item_id")
    @Column(name = "workshop_order_item_id")
    private int workshopOrderItemId;

}
