package pl.mzlnk.conferencegenerator.generator.entity;

import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.repository.data.DataRepositories;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepositories;

class StudentAttendeeGenerator extends BaseEntityGenerator {

    StudentAttendeeGenerator(EntityRepositories entityRepositories, DataRepositories dataRepositories) {
        super(EntityType.STUDENT_ATTENDEE, entityRepositories, dataRepositories);
    }

    @Override
    public void generate() {

    }

}
