package pl.mzlnk.conferencegenerator.repository.entity;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.attendee.WorkshopAttendee;

class WorkshopAttendeeRepository extends BaseEntityRepository<WorkshopAttendee> {

    WorkshopAttendeeRepository() {
        super(EntityType.WORKSHOP_ATTENDEE);
    }

}
