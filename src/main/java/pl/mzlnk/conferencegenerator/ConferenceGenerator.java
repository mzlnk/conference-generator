package pl.mzlnk.conferencegenerator;

import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.model.entity.attendee.Attendee;
import pl.mzlnk.conferencegenerator.generator.sql.SqlGenerator;
import pl.mzlnk.conferencegenerator.generator.sql.impl.mssql.MsSqlGenerator;
import pl.mzlnk.conferencegenerator.properties.ConferenceGeneratorProperties;
import pl.mzlnk.conferencegenerator.repository.entity.EntitiesRepository;
import pl.mzlnk.conferencegenerator.service.FileService;
import pl.mzlnk.conferencegenerator.service.impl.FileServiceImpl;

import static pl.mzlnk.conferencegenerator.utils.TerminalUtil.WELCOME_TITLE;

public class ConferenceGenerator {

    public static ConferenceGenerator app;

    public final FileService fileService;
    public final EntitiesRepository entitiesRepository;
    public final ConferenceGeneratorProperties properties;
    public final SqlGenerator sqlGenerator;

    public ConferenceGenerator() {
        app = this;

        fileService = FileServiceImpl.init();
        properties = new ConferenceGeneratorProperties(fileService);
        entitiesRepository = EntitiesRepository.init();

        sqlGenerator = new MsSqlGenerator(fileService, entitiesRepository, properties);
    }

    public static void main(String[] args) {
        ConferenceGenerator generator = new ConferenceGenerator();
        generator.run();

        generator.entitiesRepository.getRepository(EntityType.ATTENDEE).createOrUpdate(new Attendee(1, "John", "Smiths", "smiths@example.com", 2));

        generator.sqlGenerator.generateSqlFile();
    }

    public void run() {
        System.out.println(WELCOME_TITLE);
    }

}
