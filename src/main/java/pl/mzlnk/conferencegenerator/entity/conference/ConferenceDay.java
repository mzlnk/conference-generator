package pl.mzlnk.conferencegenerator.entity.conference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

import java.util.Calendar;

@Getter
@AllArgsConstructor
@Table(name = "conference_day")
public class ConferenceDay extends BaseEntity {

    @PrimaryKey
    @AutoIncrement
    @Column(name = "conference_day_id")
    private int conferenceDayId;

    @ForeignKey
    @Column(name = "conference_id")
    private int conferenceId;

    @Column(name = "date")
    private Calendar date;

}
