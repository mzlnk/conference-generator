package pl.mzlnk.conferencegenerator.generator.sql;

import pl.mzlnk.conferencegenerator.properties.ConferenceGeneratorProperties;
import pl.mzlnk.conferencegenerator.repository.entity.EntitiesRepository;
import pl.mzlnk.conferencegenerator.service.FileService;
import pl.mzlnk.conferencegenerator.utils.sql.Table;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class MsSqlGenerator implements SqlGenerator {

    private static final String USE_SQL_PATTERN = "USE {db_name};";
    private static final String DROP_TABLE_SQL_PATTERN = "DROP TABLE IF EXISTS {db_scheme}.{db_table};";
    private static final String CREATE_TABLE_SQL_PATTERN = "CREATE TABLE {db_scheme}.{db_table} ( {columns} );";
    private static final String INSERT_INTO_SQL_PATTERN = "INSERT INTO {db_scheme}.{db_table} ( {columns} ) VALUES ( {values} );";

    private static final String NEW_LINE = "\n";

    private static final String RESULT_FILE = "result.sql";

    private FileService fileService;
    private EntitiesRepository entitiesRepository;
    private ConferenceGeneratorProperties properties;

    private StringBuilder builder;

    public MsSqlGenerator(FileService fileService,
                          EntitiesRepository entitiesRepository,
                          ConferenceGeneratorProperties properties) {
        this.fileService = fileService;
        this.entitiesRepository = entitiesRepository;
        this.properties = properties;

        this.builder = new StringBuilder();
    }

    @Override
    public void generateSqlFile() {
        removeOldFileIfNecessary();
        parseData();
        exportDataToFile();
    }

    private void removeOldFileIfNecessary() {
        fileService.findFile(FileService.Directory.RESULT, RESULT_FILE).ifPresent(file -> {
            file.delete();
        });

    }

    private void exportDataToFile() {
        fileService.createOrUpdateFile(FileService.Directory.RESULT, RESULT_FILE, builder.toString());
    }

    private void parseData() {
        addDropTableCmds();
        addCreateTableCmds();
        addInsertIntoCmds();
    }

    private void addUseCmd() {
        String sql = USE_SQL_PATTERN
                .replace("{db_name}", properties.getDatabaseName());

        this.builder
                .append(sql)
                .append(NEW_LINE);
    }

    private void addDropTableCmds() {
        for (var repository : entitiesRepository.getAllRepositories()) {
            var clazz = repository.getEntityType().getClazz();

            String tableName = clazz.getDeclaredAnnotation(Table.class).name();

            String sql = DROP_TABLE_SQL_PATTERN
                    .replace("{db_scheme}", properties.getDatabaseScheme())
                    .replace("{db_table}", tableName);

            this.builder
                    .append(sql)
                    .append(NEW_LINE);
        }

        this.builder.append(NEW_LINE);
    }

    private void addCreateTableCmds() {
        for (var repository : entitiesRepository.getAllRepositories()) {
            var clazz = repository.getEntityType().getClazz();

            String sql = CREATE_TABLE_SQL_PATTERN;
            sql = sql.replace("{db_scheme}", properties.getDatabaseScheme());

            String tableName = clazz.getDeclaredAnnotation(Table.class).name();
            sql = sql.replace("{db_table}", tableName);

            String columns = Stream.of(clazz.getDeclaredFields())
                    .map(field -> {

                    })

        }
    }

    private void addInsertIntoCmds() {

    }

    private String fieldToColumn(Field field) {

    }

}
