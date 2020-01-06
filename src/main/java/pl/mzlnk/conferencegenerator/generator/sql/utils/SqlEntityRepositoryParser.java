package pl.mzlnk.conferencegenerator.generator.sql.utils;

import lombok.AllArgsConstructor;
import pl.mzlnk.conferencegenerator.entity.Entity;
import pl.mzlnk.conferencegenerator.entity.EntityType;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepository;
import pl.mzlnk.conferencegenerator.utils.sql.Table;

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
