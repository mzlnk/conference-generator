package pl.mzlnk.conferencegenerator.repository.entity;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.conference.ConferenceDayPrice;

class ConferenceDayPriceRepository extends BaseEntityRepository<ConferenceDayPrice> {

    ConferenceDayPriceRepository() {
        super(EntityType.CONFERENCE_DAY_PRICE);
    }

}
