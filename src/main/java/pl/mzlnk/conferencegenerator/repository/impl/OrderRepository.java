package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.order.Order;

class OrderRepository extends BaseEntityRepository<Order> {

    OrderRepository() {
        super(EntityType.ORDER);
    }

}
