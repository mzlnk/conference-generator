package pl.mzlnk.conferencegenerator.entity.attendee;

import lombok.*;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

@AllArgsConstructor
@Table(name = "attendee")
public class Attendee extends BaseEntity {

    @PrimaryKey
    @AutoIncrement
    @Column(name = "attendee_id")
    private String attendeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ForeignKey
    @Column(name = "company_id")
    private int companyId;

}
