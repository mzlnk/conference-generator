package pl.mzlnk.conferencegenerator.generator.entity;

import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.repository.data.DataRepositories;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepositories;

class BuyerGenerator extends BaseEntityGenerator {

    BuyerGenerator(EntityRepositories entityRepositories, DataRepositories dataRepositories) {
        super(EntityType.BUYER, entityRepositories, dataRepositories);
    }

    @Override
    public void generate() {

    }

}
