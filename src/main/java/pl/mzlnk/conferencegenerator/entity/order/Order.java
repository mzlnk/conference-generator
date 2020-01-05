package pl.mzlnk.conferencegenerator.entity.order;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.entity.PaymentType;
import pl.mzlnk.conferencegenerator.utils.sql.*;

import java.util.Calendar;

@Getter
@Table(name = "order")
public class Order extends BaseEntity {

    @Builder
    public Order(int orderId, int buyerId, boolean cancelled, PaymentType paymentType, double value, Calendar date) {
        super(EntityType.ORDER);

        this.orderId = orderId;
        this.buyerId = buyerId;
        this.cancelled = cancelled;
        this.paymentType = paymentType;
        this.value = value;
        this.date = date;
    }

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
    private PaymentType paymentType;

    @Column(name = "value")
    private double value;

    @Column(name = "date")
    private Calendar date;

}
