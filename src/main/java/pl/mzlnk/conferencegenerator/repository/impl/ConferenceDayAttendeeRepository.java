package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.attendee.ConferenceDayAttendee;

class ConferenceDayAttendeeRepository extends BaseEntityRepository<ConferenceDayAttendee> {

    ConferenceDayAttendeeRepository() {
        super(EntityType.CONFERENCE_DAY_ATTENDEE);
    }

}
