package pl.mzlnk.conferencegenerator.generator.entity;

import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.repository.data.DataRepositories;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepositories;

class WorkshopGenerator extends BaseEntityGenerator {

    WorkshopGenerator(EntityRepositories entityRepositories, DataRepositories dataRepositories) {
        super(EntityType.WORKSHOP, entityRepositories, dataRepositories);
    }

    @Override
    public void generate() {

    }

}
