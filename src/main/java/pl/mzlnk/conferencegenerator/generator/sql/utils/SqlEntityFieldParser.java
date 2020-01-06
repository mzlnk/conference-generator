package pl.mzlnk.conferencegenerator.generator.sql.utils;

import pl.mzlnk.conferencegenerator.entity.Entity;
import pl.mzlnk.conferencegenerator.utils.sql.*;

import java.lang.reflect.Field;

public class SqlEntityFieldParser {

    private final Entity entity;
    private final Field field;

    public SqlEntityFieldParser(Field field) {
        this(field, null);
    }

    public SqlEntityFieldParser(Field field, Entity entity) {
        this.field = field;
        this.entity = entity;

        this.field.setAccessible(true);
    }

    public String getStringValue() {
        try {
            return String.valueOf(field.get(entity));
        } catch (IllegalAccessException e) {
            return ""; // todo: add log support here
        }
    }

    public String getColumnName() {
        return field.getDeclaredAnnotation(Column.class).name();
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
