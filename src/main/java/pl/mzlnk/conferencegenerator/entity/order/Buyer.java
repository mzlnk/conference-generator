package pl.mzlnk.conferencegenerator.entity.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.generator.annotations.*;

@Getter
@AllArgsConstructor
@Table(name = "buyer")
public class Buyer extends BaseEntity {

    @PrimaryKey
    @AutoIncrement
    @Column(name = "buyer_id")
    private int buyer_id;

    @ForeignKey
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

}
