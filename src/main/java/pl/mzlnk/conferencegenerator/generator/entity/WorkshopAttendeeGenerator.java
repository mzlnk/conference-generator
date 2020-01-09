package pl.mzlnk.conferencegenerator.generator.entity;

import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.repository.data.DataRepositories;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepositories;

class WorkshopAttendeeGenerator extends BaseEntityGenerator {

    WorkshopAttendeeGenerator(EntityRepositories entityRepositories, DataRepositories dataRepositories) {
        super(EntityType.WORKSHOP_ATTENDEE, entityRepositories, dataRepositories);
    }

    @Override
    public void generate() {

    }

}
