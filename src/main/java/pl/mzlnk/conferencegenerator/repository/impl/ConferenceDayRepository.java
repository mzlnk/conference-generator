package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.conference.ConferenceDay;

class ConferenceDayRepository extends BaseEntityRepository<ConferenceDay> {

    ConferenceDayRepository() {
        super(EntityType.CONFERENCE_DAY);
    }

}
