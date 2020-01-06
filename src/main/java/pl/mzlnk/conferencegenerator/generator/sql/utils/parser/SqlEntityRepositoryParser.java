package pl.mzlnk.conferencegenerator.generator.sql.utils.parser;

import lombok.AllArgsConstructor;
import pl.mzlnk.conferencegenerator.model.entity.EntityType;
import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.Table;

import java.lang.reflect.Field;

@AllArgsConstructor
public class SqlEntityRepositoryParser {

    private EntityType entityType;

    public String getTableName() {
        return entityType
                .getClazz()
                .getDeclaredAnnotation(Table.class)
                .name();
    }

    public Field[] getFields() {
        return entityType
                .getClazz()
                .getDeclaredFields();
    }

}
