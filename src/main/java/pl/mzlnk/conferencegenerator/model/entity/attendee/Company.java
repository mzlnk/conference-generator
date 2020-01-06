package pl.mzlnk.conferencegenerator.model.entity.attendee;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.model.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.AutoIncrement;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.Column;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.PrimaryKey;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.Table;

@Getter
@Table(name = "company")
public class Company extends BaseEntity {

    @Builder
    public Company(int companyId, String name, String address, String phone) {
        super(EntityType.COMPANY);

        this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

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
