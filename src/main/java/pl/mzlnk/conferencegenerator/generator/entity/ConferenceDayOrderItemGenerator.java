package pl.mzlnk.conferencegenerator.generator.entity;

import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.model.entity.conference.ConferenceDay;
import pl.mzlnk.conferencegenerator.model.entity.order.ConferenceDayOrderItem;
import pl.mzlnk.conferencegenerator.model.entity.order.Order;
import pl.mzlnk.conferencegenerator.repository.data.DataRepositories;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepositories;

import java.util.HashSet;
import java.util.Set;

import static pl.mzlnk.conferencegenerator.utils.RandomUtil.r;

class ConferenceDayOrderItemGenerator extends BaseEntityGenerator {

    ConferenceDayOrderItemGenerator(EntityRepositories entityRepositories, DataRepositories dataRepositories) {
        super(EntityType.CONFERENCE_DAY_ORDER_ITEM, entityRepositories, dataRepositories);
    }

    @Override
    public void generate() {
        var conferenceDayOrderItemRepository = entityRepositories.<ConferenceDayOrderItem>getRepository(EntityType.CONFERENCE_DAY_ORDER_ITEM);
        var orderRepository = entityRepositories.<Order>getRepository(EntityType.ORDER);
        var conferenceDayRepository = entityRepositories.<ConferenceDay>getRepository(EntityType.CONFERENCE_DAY);

        final int conferenceDaySize = conferenceDayRepository.findAll().size();

        orderRepository
                .findAll()
                .forEach(order -> {
                    int conferenceDays = r.nextInt(7) + 1;

                    Set<Integer> conferenceIds = new HashSet<>();
                    for(int i = 0; i < conferenceDays; i++) {
                        conferenceIds.add(r.nextInt(conferenceDaySize) + 1);
                    }

                    conferenceIds.forEach(conferenceId -> {
                        conferenceDayOrderItemRepository.createOrUpdate(new ConferenceDayOrderItem(id++, order.getOrderId(), conferenceId));
                    });
                });

        System.out.println("generated: " + conferenceDayOrderItemRepository.findAll().size() + " conference day order item entities");
    }

}
