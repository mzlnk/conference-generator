package pl.mzlnk.conferencegenerator.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Calendar;

@Getter
@AllArgsConstructor
public class WorkshopDetails {

    private String name;
    private String description;
    private double price;
    private int attendeesLimit;

}
