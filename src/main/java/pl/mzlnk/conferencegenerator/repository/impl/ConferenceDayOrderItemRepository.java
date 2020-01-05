package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.order.ConferenceDayOrderItem;

class ConferenceDayOrderItemRepository extends BaseEntityRepository<ConferenceDayOrderItem> {

    ConferenceDayOrderItemRepository() {
        super(EntityType.CONFERENCE_DAY_ORDER_ITEM);
    }

}
