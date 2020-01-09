package pl.mzlnk.conferencegenerator.generator.entity;

import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.repository.data.DataRepositories;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepositories;

class WorkshopOrderItemGenerator extends BaseEntityGenerator {

    WorkshopOrderItemGenerator(EntityRepositories entityRepositories, DataRepositories dataRepositories) {
        super(EntityType.WORKSHOP_ORDER_ITEM, entityRepositories, dataRepositories);
    }

    @Override
    public void generate() {

    }

}
