package pl.mzlnk.conferencegenerator.generator.sql.impl.mssql;

import pl.mzlnk.conferencegenerator.entity.Entity;
import pl.mzlnk.conferencegenerator.generator.sql.impl.BaseSqlGenerator;
import pl.mzlnk.conferencegenerator.generator.sql.utils.EntityRepositoryDependencyComparator;
import pl.mzlnk.conferencegenerator.generator.sql.utils.SqlEntityFieldParser;
import pl.mzlnk.conferencegenerator.generator.sql.utils.SqlEntityRepositoryParser;
import pl.mzlnk.conferencegenerator.properties.ConferenceGeneratorProperties;
import pl.mzlnk.conferencegenerator.repository.entity.EntitiesRepository;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepository;
import pl.mzlnk.conferencegenerator.service.FileService;
import pl.mzlnk.conferencegenerator.utils.sql.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MsSqlGenerator extends BaseSqlGenerator {

    private static final String USE_SQL_PATTERN = "USE {db_name};";
    private static final String DROP_TABLE_SQL_PATTERN = "DROP TABLE IF EXISTS {db_scheme}.{db_table};";
    private static final String CREATE_TABLE_SQL_PATTERN = "CREATE TABLE {db_scheme}.{db_table} ( {data} );";
    private static final String INSERT_INTO_SQL_PATTERN = "INSERT INTO {db_scheme}.{db_table} ( {columns} ) VALUES ( {values} );";

    private static final String DATA_TYPE_SQL_PATTERN = "{column} {data_type} {primary_key} {auto_increment} {not_null} ";
    private static final String FOREIGN_KEY_SQL_PATTERN = "FOREIGN KEY ({column_name}) REFERENCES {db_scheme}.{foreign_table} ({foreign_column})";

    private static final String PRIMARY_KEY = "PRIMARY KEY";
    private static final String AUTO_INCREMENT = "IDENTITY (1, 1)";
    private static final String NOT_NULL = "NOT NULL";

    private static final String SINGLE_SPACE = " ";
    private static final String DOUBLE_SPACE = "  ";

    private static final String COMMA_WITH_SPACE = " ,";
    private static final String COMMA = ",";

    public MsSqlGenerator(FileService fileService, EntitiesRepository entitiesRepository, ConferenceGeneratorProperties properties) {
        super(fileService, entitiesRepository, properties);
    }

    @Override
    protected String useDatabaseSql() {
        return USE_SQL_PATTERN
                .replace("{db_name}", properties.getDatabaseName());
    }

    @Override
    protected String dropTableSql(EntityRepository<? extends Entity> repository) {
        var parser = new SqlEntityRepositoryParser(repository);

        return DROP_TABLE_SQL_PATTERN
                .replace("{db_scheme}", properties.getDatabaseScheme())
                .replace("{db_table}", parser.getTableName());
    }

    @Override
    protected String createTableSql(EntityRepository<? extends Entity> repository) {
        var repositoryParser = new SqlEntityRepositoryParser(repository);

        String sql = CREATE_TABLE_SQL_PATTERN;

        sql = sql.replace("{db_scheme}", properties.getDatabaseScheme());
        sql = sql.replace("{db_table}", repositoryParser.getTableName());

        List<String> data = new ArrayList<>();

        data.addAll(
                Stream.of(repositoryParser.getFields())
                        .map(field -> new SqlEntityFieldParser(field))
                        .map(parser -> {
                            return DATA_TYPE_SQL_PATTERN
                                    .replace("{column}", parser.getColumnName())
                                    .replace("{data_type}", MsSqlDataTypeEnum.fromClass(parser.getColumnType()).getSqlDataType())
                                    .replace("{primary_key}", parser.isPrimaryKey() ? PRIMARY_KEY : "")
                                    .replace("{auto_increment}", parser.isAutoIncrement() ? AUTO_INCREMENT : "")
                                    .replace("{not_null}", parser.isNotNull() ? NOT_NULL : "")
                                    .replace(DOUBLE_SPACE, SINGLE_SPACE)
                                    .replace(COMMA_WITH_SPACE, COMMA);
                        })
                        .collect(Collectors.toList())
        );
    }

    @Override
    protected String insertIntoSql(Entity entity) {

    }

    private void generateCreateTableCmds() {
        for (var repository : entitiesRepository.getAllRepositories()) {
            var clazz = repository.getEntityType().getClazz();

            String sql = CREATE_TABLE_SQL_PATTERN;
            sql = sql.replace("{db_scheme}", properties.getDatabaseScheme());

            String tableName = clazz.getDeclaredAnnotation(Table.class).name();
            sql = sql.replace("{db_table}", tableName);

            List<String> data = new ArrayList<>();

            columns.addAll(Stream.of(clazz.getDeclaredFields())
                    .map(field -> {
                        String columnName = field.getDeclaredAnnotation(Column.class).name();
                        String columnType = MsSqlDataTypeEnum.fromClass(field.getType()).getSqlDataType();
                        boolean primaryKey = field.getDeclaredAnnotation(PrimaryKey.class) != null;
                        boolean autoIncrement = field.getDeclaredAnnotation(AutoIncrement.class) != null;
                        boolean notNull = field.getDeclaredAnnotation(NotNull.class) != null;

                        return new StringBuilder()
                                .append(columnName)
                                .append(" ")
                                .append(columnType)
                                .append(primaryKey ? " PRIMARY KEY" : "")
                                .append(autoIncrement ? " IDENTITY (1, 1)" : "")
                                .append(notNull ? " NOT NULL" : "")
                                .toString();
                    })
                    .collect(Collectors.toList()));

            columns.addAll(Stream.of(clazz.getDeclaredFields())
                    .filter(field -> field.getDeclaredAnnotation(ForeignKey.class) != null)
                    .map(field -> {
                        String columnName = field.getDeclaredAnnotation(Column.class).name();
                        String foreignTableName = field.getDeclaredAnnotation(ForeignKey.class).table();
                        String foreignColumn = field.getDeclaredAnnotation(ForeignKey.class).column();

                        return "FOREIGN KEY ({column_name}) REFERENCES {db_scheme}.{foreign_table} ({foreign_column})"
                                .replace("{column_name}", columnName)
                                .replace("{db_scheme}", properties.getDatabaseScheme())
                                .replace("{foreign_table}", foreignTableName)
                                .replace("{foreign_column}", foreignColumn);
                    })
                    .collect(Collectors.toList()));

            sql = sql.replace("{columns}", String.join(", ", columns));

            this.builder
                    .append(sql)
                    .append(NEW_LINE);
        }
    }

    private void generateInsertIntoCmds() {
        entitiesRepository
                .getAllRepositories()
                .stream()
                .sorted(new EntityRepositoryDependencyComparator())

    }

    private String fieldToColumn(Field field) {

    }

}
