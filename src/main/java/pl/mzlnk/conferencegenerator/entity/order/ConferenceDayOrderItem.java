package pl.mzlnk.conferencegenerator.entity.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

@Getter
@AllArgsConstructor
@Table(name = "conference_day_order_item")
public class ConferenceDayOrderItem extends BaseEntity {

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
