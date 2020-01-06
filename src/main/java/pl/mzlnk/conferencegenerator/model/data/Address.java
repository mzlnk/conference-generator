package pl.mzlnk.conferencegenerator.model.data;

import lombok.Getter;

@Getter
public class Address {

    private static final String ADDRESS_PATTERN = "{street} {street_number}, {city}, {country}";

    private String address;

    public Address(String country, String city, String street, int streetNumber) {
        this.address = ADDRESS_PATTERN
                .replace("{street}", street)
                .replace("{streetNumber}", String.valueOf(streetNumber))
                .replace("{city}", city)
                .replace("{country}", country);
    }

}
