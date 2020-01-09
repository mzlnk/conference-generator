package pl.mzlnk.conferencegenerator.generator.entity;

import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.repository.data.DataRepositories;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepositories;

class OrderGenerator extends BaseEntityGenerator {

    OrderGenerator(EntityRepositories entityRepositories, DataRepositories dataRepositories) {
        super(EntityType.ORDER, entityRepositories, dataRepositories);
    }

    @Override
    public void generate() {

    }

}
