package pl.mzlnk.conferencegenerator.entity.conference;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.utils.sql.*;

import java.util.Calendar;

@Getter
@Table(name = "conference_day_price")
public class ConferenceDayPrice extends BaseEntity {

    @Builder
    public ConferenceDayPrice(int priceId, int conferenceDayId, double value, String description, Calendar expirationDate) {
        super(EntityType.CONFERENCE_DAY_PRICE);

        this.priceId = priceId;
        this.conferenceDayId = conferenceDayId;
        this.value = value;
        this.description = description;
        this.expirationDate = expirationDate;
    }

    @PrimaryKey
    @AutoIncrement
    @Column(name = "price_id")
    private int priceId;

    @ForeignKey
    @Column(name = "conference_day_id")
    private int conferenceDayId;

    @Column(name = "value")
    private double value;

    @Column(name = "description")
    private String description;

    @Column(name = "expiration_date")
    private Calendar expirationDate;

}
