package pl.mzlnk.conferencegenerator.entity.conference;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

import java.util.Calendar;

@Getter
@Table(name = "workshop")
public class Workshop extends BaseEntity {

    @Builder
    public Workshop(int workshopId, int conferenceDayId, String name, String description, double price, Calendar dateStart, Calendar dateEnd, int attendeesLimit) {
        super(EntityType.WORKSHOP);

        this.workshopId = workshopId;
        this.conferenceDayId = conferenceDayId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.attendeesLimit = attendeesLimit;
    }

    @PrimaryKey
    @AutoIncrement
    @Column(name = "workshop_id")
    private int workshopId;

    @ForeignKey
    @Column(name = "conference_day_id")
    private int conferenceDayId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "date_start")
    private Calendar dateStart;

    @Column(name = "date_end")
    private Calendar dateEnd;

    @Column(name = "attendees_limit")
    private int attendeesLimit;



}
