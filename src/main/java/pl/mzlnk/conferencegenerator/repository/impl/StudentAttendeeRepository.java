package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.attendee.StudentAttendee;

class StudentAttendeeRepository extends BaseEntityRepository<StudentAttendee> {

    StudentAttendeeRepository() {
        super(EntityType.STUDENT_ATTENDEE);
    }

}
