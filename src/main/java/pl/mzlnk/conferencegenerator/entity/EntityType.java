package pl.mzlnk.conferencegenerator.entity;

import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.attendee.*;
import pl.mzlnk.conferencegenerator.entity.conference.*;
import pl.mzlnk.conferencegenerator.entity.order.*;

public enum EntityType {

    ATTENDEE(Attendee.class),
    COMPANY(Company.class),
    CONFERENCE_DAY_ATTENDEE(ConferenceDayAttendee.class),
    STUDENT_ATTENDEE(StudentAttendee.class),
    WORKSHOP_ATTENDEE(WorkshopAttendee.class),

    CONFERENCE(Conference.class),
    CONFERENCE_DAY(ConferenceDay.class),
    CONFERENCE_DAY_PRICE(ConferenceDayPrice.class),
    WORKSHOP(Workshop.class),

    BUYER(Buyer.class),
    ORDER(Order.class),
    CONFERENCE_DAY_ORDER_ITEM(ConferenceDayOrderItem.class),
    WORKSHOP_ORDER_ITEM(WorkshopOrderItem.class);

    @Getter
    private Class<? extends Entity> clazz;

    private EntityType(Class<? extends Entity> clazz) {
        this.clazz = clazz;
    }

}
