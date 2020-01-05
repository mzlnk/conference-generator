package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.conference.Conference;

class ConferenceRepository extends BaseEntityRepository<Conference> {

    ConferenceRepository() {
        super(EntityType.CONFERENCE);
    }

}
