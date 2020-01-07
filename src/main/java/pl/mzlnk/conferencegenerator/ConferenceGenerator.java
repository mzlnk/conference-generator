package pl.mzlnk.conferencegenerator;

import lombok.NoArgsConstructor;
import pl.mzlnk.conferencegenerator.generator.entity.EntityGenerators;
import pl.mzlnk.conferencegenerator.generator.sql.SqlGenerator;
import pl.mzlnk.conferencegenerator.generator.sql.impl.mssql.MsSqlGenerator;
import pl.mzlnk.conferencegenerator.properties.ConferenceGeneratorProperties;
import pl.mzlnk.conferencegenerator.repository.data.DataRepositories;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepositories;
import pl.mzlnk.conferencegenerator.service.FileService;
import pl.mzlnk.conferencegenerator.service.impl.FileServiceImpl;

import static pl.mzlnk.conferencegenerator.utils.TerminalUtil.WELCOME_TITLE;

@NoArgsConstructor
public class ConferenceGenerator extends Application {

    public static void main(String[] args) {
        Application app = new ConferenceGenerator();
        app.run();
    }

    private FileService fileService;
    private ConferenceGeneratorProperties properties;

    private EntityRepositories entityRepositories;
    private DataRepositories dataRepositories;

    private EntityGenerators entityGenerators;
    private SqlGenerator sqlGenerator;

    @Override
    protected String welcomeTitle() {
        return WELCOME_TITLE;
    }

    @Override
    protected void init() {
        fileService = FileServiceImpl.init();
        properties = new ConferenceGeneratorProperties(fileService);

        entityRepositories = EntityRepositories.init();
        dataRepositories = DataRepositories.init(fileService, properties);

        entityGenerators = EntityGenerators.init();
        sqlGenerator = new MsSqlGenerator(fileService, entityRepositories, properties);
    }

    @Override
    protected void run() {
        entityGenerators.generate();
        sqlGenerator.generateSqlFile();
    }

}
