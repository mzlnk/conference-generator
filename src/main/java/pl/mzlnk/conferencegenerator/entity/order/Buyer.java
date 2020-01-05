package pl.mzlnk.conferencegenerator.entity.order;

import lombok.Builder;
import lombok.Getter;
import pl.mzlnk.conferencegenerator.entity.BaseEntity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.utils.sql.*;

@Getter
@Table(name = "buyer")
public class Buyer extends BaseEntity {

    @Builder
    public Buyer(int buyerId, int companyId, String firstName, String lastName, String address) {
        super(EntityType.BUYER);

        this.buyerId = buyerId;
        this.companyId = companyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @PrimaryKey
    @AutoIncrement
    @Column(name = "buyer_id")
    private int buyerId;

    @ForeignKey(table = "company", column = "company_id")
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

}
