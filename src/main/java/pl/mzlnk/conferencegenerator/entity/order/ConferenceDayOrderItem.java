package pl.mzlnk.conferencegenerator.entity.order;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

@Getter
@Table(name = "conference_day_order_item")
public class ConferenceDayOrderItem extends BaseEntity {

    @Builder
    public ConferenceDayOrderItem(int conferenceDayOrderItemId, int orderId, int conferenceDayId) {
        super(EntityType.CONFERENCE_DAY_ORDER_ITEM);

        this.conferenceDayOrderItemId = conferenceDayOrderItemId;
        this.orderId = orderId;
        this.conferenceDayId = conferenceDayId;
    }

    @PrimaryKey
    @AutoIncrement
    @Column(name = "conference_day_order_item_id")
    private int conferenceDayOrderItemId;

    @ForeignKey
    @Column(name = "order_id")
    private int orderId;

    @ForeignKey
    @Column(name = "conference_day_id")
    private int conferenceDayId;

}
