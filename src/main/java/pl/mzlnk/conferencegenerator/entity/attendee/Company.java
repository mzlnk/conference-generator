package pl.mzlnk.conferencegenerator.entity.attendee;

import lombok.AllArgsConstructor;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.AutoIncrement;
import pl.mzlnk.conferencegenerator.generator.annotations.Column;
import pl.mzlnk.conferencegenerator.generator.annotations.PrimaryKey;
import pl.mzlnk.conferencegenerator.generator.annotations.Table;

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
