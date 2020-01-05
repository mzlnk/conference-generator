package pl.mzlnk.conferencegenerator.entity.order;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.utils.sql.*;

@Getter
@Table(name = "workshop_order_item")
public class WorkshopOrderItem extends BaseEntity {

    @Builder
    public WorkshopOrderItem(int workshopOrderItemId, int conferenceDayOrderId, int workshopId) {
        super(EntityType.WORKSHOP_ORDER_ITEM);

        this.workshopOrderItemId = workshopOrderItemId;
        this.conferenceDayOrderId = conferenceDayOrderId;
        this.workshopId = workshopId;
    }

    @PrimaryKey
    @AutoIncrement
    @Column(name = "workshop_order_item_id")
    private int workshopOrderItemId;

    @ForeignKey
    @Column(name = "conference_day_order_id")
    private int conferenceDayOrderId;

    @ForeignKey
    @Column(name = "workshop_id")
    private int workshopId;

}
