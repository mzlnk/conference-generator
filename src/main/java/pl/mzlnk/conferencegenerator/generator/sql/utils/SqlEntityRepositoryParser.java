package pl.mzlnk.conferencegenerator.generator.sql.utils;

import lombok.AllArgsConstructor;
import pl.mzlnk.conferencegenerator.entity.Entity;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepository;
import pl.mzlnk.conferencegenerator.utils.sql.Table;

import java.lang.reflect.Field;

@AllArgsConstructor
public class SqlEntityRepositoryParser {

    private EntityRepository<? extends Entity> repository;

    public String getTableName() {
        return repository
                .getEntityType()
                .getClazz()
                .getDeclaredAnnotation(Table.class)
                .name();
    }

    public Field[] getFields() {
        return repository
                .getEntityType()
                .getClazz()
                .getDeclaredFields();
    }

}
