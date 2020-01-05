package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.conference.Workshop;

class WorkshopRepository extends BaseEntityRepository<Workshop> {

    WorkshopRepository() {
        super(EntityType.WORKSHOP);
    }

}
