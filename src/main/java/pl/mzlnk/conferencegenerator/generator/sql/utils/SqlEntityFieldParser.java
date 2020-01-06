package pl.mzlnk.conferencegenerator.generator.sql.utils;

import lombok.AllArgsConstructor;
import pl.mzlnk.conferencegenerator.utils.sql.*;

import java.lang.reflect.Field;

@AllArgsConstructor
public class SqlEntityFieldParser {

    private final Field field;

    public String getColumnName() {
        return field.getDeclaredAnnotation(Table.class).name();
    }

    public Class<?> getColumnType() {
        return field.getType();
    }

    public boolean isPrimaryKey() {
        return field.getDeclaredAnnotation(PrimaryKey.class) != null;
    }

    public boolean isForeignKey() {
        return field.getDeclaredAnnotation(ForeignKey.class) != null;
    }

    public boolean isAutoIncrement() {
        return field.getDeclaredAnnotation(AutoIncrement.class) != null;
    }

    public boolean isNotNull() {
        return field.getDeclaredAnnotation(NotNull.class) != null;
    }

    public String getForeignTableName() {
        return field.getDeclaredAnnotation(ForeignKey.class).table();
    }

    public String getForeignColumnName() {
        return field.getDeclaredAnnotation(ForeignKey.class).column();
    }

}
