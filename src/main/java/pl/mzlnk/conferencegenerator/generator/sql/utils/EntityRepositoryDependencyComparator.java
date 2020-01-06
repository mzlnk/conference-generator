package pl.mzlnk.conferencegenerator.generator.sql.utils;

import pl.mzlnk.conferencegenerator.entity.Entity;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepository;
import pl.mzlnk.conferencegenerator.utils.sql.ForeignKey;
import pl.mzlnk.conferencegenerator.utils.sql.Table;

import java.util.Comparator;
import java.util.stream.Stream;

public class EntityRepositoryDependencyComparator implements Comparator<EntityRepository<? extends Entity>> {


    @Override
    public int compare(EntityRepository<? extends Entity> r1, EntityRepository<? extends Entity> r2) {
        Class<?> clazz1 = r1.getEntityType().getClazz();
        Class<?> clazz2 = r2.getEntityType().getClazz();

        String tableName1 = clazz1.getDeclaredAnnotation(Table.class).name();
        String tableName2 = clazz2.getDeclaredAnnotation(Table.class).name();

        boolean firstDepend = Stream.of(clazz1.getDeclaredFields())
                .filter(field -> field.getDeclaredAnnotation(ForeignKey.class) != null)
                .map(field -> field.getDeclaredAnnotation(ForeignKey.class))
                .map(ForeignKey::table)
                .anyMatch(table -> table.equals(tableName2));

        if(firstDepend) return -1;

        boolean secondDepend = Stream.of(clazz2.getDeclaredFields())
                .filter(field -> field.getDeclaredAnnotation(ForeignKey.class) != null)
                .map(field -> field.getDeclaredAnnotation(ForeignKey.class))
                .map(ForeignKey::table)
                .anyMatch(table -> table.equals(tableName1));

        if(secondDepend) return 1;

        return 0;
    }

}
