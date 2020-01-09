package pl.mzlnk.conferencegenerator.generator.entity;

import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.repository.data.DataRepositories;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepositories;

class ConferenceDayAttendeeGenerator extends BaseEntityGenerator {

    ConferenceDayAttendeeGenerator(EntityRepositories entityRepositories, DataRepositories dataRepositories) {
        super(EntityType.CONFERENCE_DAY_ATTENDEE, entityRepositories, dataRepositories);
    }

    @Override
    public void generate() {

    }

}
