package pl.mzlnk.conferencegenerator.properties;

import lombok.Getter;
import pl.mzlnk.conferencegenerator.service.FileService;
import pl.mzlnk.conferencegenerator.utils.CalendarUtil;

import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

@Getter
public class ConferenceGeneratorProperties {

    private static final String PROPERTIES_FILE = "database.properties";

    private String databaseName;
    private String databaseScheme;

    private double workshopPriceMin;
    private double workshopPriceMax;

    private int workshopAttendeesLimitMin;
    private int workshopAttendeesLimitMax;

    private double conferenceDayPriceMin;
    private double conferenceDayPriceMax;

    private Calendar conferenceDateMin;
    private Calendar conferenceDateMax;

    public ConferenceGeneratorProperties(FileService fileService) {
        loadProperties(fileService);
    }

    private void loadProperties(FileService fileService) {
        fileService.findFile(FileService.Directory.PROPERTIES, PROPERTIES_FILE).ifPresent(file -> {
            Properties properties = new Properties();

            try {
                properties.load(new FileReader(file));

                this.databaseName = properties.getProperty("database.name", "default_database");
                this.databaseScheme = properties.getProperty("database.scheme", "default_scheme");

                this.workshopPriceMin = (Double) properties.getOrDefault("data.workshop.price.min", 1D);
                this.workshopPriceMax = (Double) properties.getOrDefault("data.workshop.price.max", 100D);

                this.workshopAttendeesLimitMin = (Integer) properties.getOrDefault("data.workshop.attendees.limit.min", 5);
                this.workshopAttendeesLimitMax = (Integer) properties.getOrDefault("data.workshop.attendees.limit.max", 50);

                this.conferenceDayPriceMin = (Double) properties.getOrDefault("data.conference.day.price.min", 1D);
                this.conferenceDayPriceMax = (Double) properties.getOrDefault("data.conference.day.price.max", 100D);

                this.conferenceDateMin = CalendarUtil.fromString(properties.getProperty("data.conference.date.min", "2017-01-01 00:00:00"));
                this.conferenceDateMax = CalendarUtil.fromString(properties.getProperty("data.conference.date.max", "2019-12-31 23:59:59"));

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

}
