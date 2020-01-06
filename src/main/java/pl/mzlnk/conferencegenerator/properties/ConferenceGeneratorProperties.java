package pl.mzlnk.conferencegenerator.properties;

import lombok.Getter;
import pl.mzlnk.conferencegenerator.service.FileService;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Getter
public class ConferenceGeneratorProperties {

    private static final String PROPERTIES_FILE = "database.properties";

    private String databaseName;
    private String databaseScheme;

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

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

}
