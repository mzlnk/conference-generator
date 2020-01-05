package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.order.WorkshopOrderItem;

class WorkshopOrderItemRepository extends BaseEntityRepository<WorkshopOrderItem> {

    WorkshopOrderItemRepository() {
        super(EntityType.WORKSHOP_ORDER_ITEM);
    }

}
