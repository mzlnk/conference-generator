package pl.mzlnk.conferencegenerator.generator.entity;

import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.repository.data.DataRepositories;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepositories;

class CompanyGenerator extends BaseEntityGenerator {

    CompanyGenerator(EntityRepositories entityRepositories, DataRepositories dataRepositories) {
        super(EntityType.COMPANY, entityRepositories, dataRepositories);
    }

    @Override
    public void generate() {

    }

}
