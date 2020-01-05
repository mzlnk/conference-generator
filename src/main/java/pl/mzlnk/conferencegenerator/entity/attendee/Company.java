package pl.mzlnk.conferencegenerator.entity.attendee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

@Getter
@AllArgsConstructor
@Table(name = "company")
public class Company extends BaseEntity {

    @PrimaryKey
    @AutoIncrement
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

}
