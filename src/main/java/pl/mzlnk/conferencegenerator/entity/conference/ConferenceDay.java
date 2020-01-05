package pl.mzlnk.conferencegenerator.entity.conference;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.utils.sql.*;

import java.util.Calendar;

@Getter
@Table(name = "conference_day")
public class ConferenceDay extends BaseEntity {

    @Builder
    public ConferenceDay(int conferenceDayId, int conferenceId, Calendar date) {
        super(EntityType.CONFERENCE_DAY);

        this.conferenceDayId = conferenceDayId;
        this.conferenceId = conferenceId;
        this.date = date;
    }

    @PrimaryKey
    @AutoIncrement
    @Column(name = "conference_day_id")
    private int conferenceDayId;

    @ForeignKey(table = "conference", column = "conference_id")
    @Column(name = "conference_id")
    private int conferenceId;

    @Column(name = "date")
    private Calendar date;

}
