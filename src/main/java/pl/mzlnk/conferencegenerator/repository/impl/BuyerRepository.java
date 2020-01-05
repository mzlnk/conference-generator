package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.order.Buyer;

class BuyerRepository extends BaseEntityRepository<Buyer> {

    BuyerRepository() {
        super(EntityType.BUYER);
    }

}
