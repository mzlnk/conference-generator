package pl.mzlnk.conferencegenerator.entity.conference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

import java.util.Calendar;

@Getter
@AllArgsConstructor
@Table(name = "conference_day_price")
public class ConferenceDayPrice extends BaseEntity {

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
