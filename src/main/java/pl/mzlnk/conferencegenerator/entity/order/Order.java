package pl.mzlnk.conferencegenerator.entity.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

import java.util.Calendar;

@Getter
@AllArgsConstructor
@Table(name = "order")
public class Order extends BaseEntity {

    @PrimaryKey
    @AutoIncrement
    @Column(name = "order_id")
    private int orderId;

    @ForeignKey
    @Column(name = "buyer_id")
    private int buyerId;

    @Column(name = "cancelled")
    private boolean cancelled;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "value")
    private double value;

    @Column(name = "date")
    private Calendar date;

}
