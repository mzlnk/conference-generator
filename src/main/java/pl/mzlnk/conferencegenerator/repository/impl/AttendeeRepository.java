package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.attendee.Attendee;

class AttendeeRepository extends BaseEntityRepository<Attendee> {

    AttendeeRepository() {
        super(EntityType.ATTENDEE);
    }

}
