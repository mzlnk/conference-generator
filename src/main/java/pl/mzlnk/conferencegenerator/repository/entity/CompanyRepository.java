package pl.mzlnk.conferencegenerator.repository.entity;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.attendee.Company;

class CompanyRepository extends BaseEntityRepository<Company> {

    CompanyRepository() {
        super(EntityType.COMPANY);
    }

}
