package pl.mzlnk.conferencegenerator.entity.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

@Getter
@AllArgsConstructor
@Table(name = "workshop_order_item")
public class WorkshopOrderItem extends BaseEntity {

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
