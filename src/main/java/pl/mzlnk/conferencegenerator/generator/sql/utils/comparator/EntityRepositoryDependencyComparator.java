package pl.mzlnk.conferencegenerator.generator.sql.utils.comparator;

import pl.mzlnk.conferencegenerator.generator.sql.utils.annotation.ForeignKey;
import pl.mzlnk.conferencegenerator.model.entity.Entity;
import pl.mzlnk.conferencegenerator.repository.entity.EntityRepository;

import java.util.Comparator;
import java.util.stream.Stream;

public class EntityRepositoryDependencyComparator implements Comparator<EntityRepository<? extends Entity>> {

    @Override
    public int compare(EntityRepository<? extends Entity> r1, EntityRepository<? extends Entity> r2) {
        if (r1.getEntityType().equals(r2.getEntityType())) {
            return 0;
        } else {
            System.out.println(r1.getEntityType() + " from " + r2.getEntityType());
            boolean dependent = isDependent(r1, r2);
            System.out.println("result: " + dependent);
            return dependent ? 1 : -1;
        }
    }

    private static boolean isDependent(EntityRepository<? extends Entity> repository, EntityRepository<? extends Entity> from) {
        var clazz1 = repository.getEntityType().getClazz();
        var clazz2 = from.getEntityType().getClazz();

        return isDependent(clazz1, clazz2);
    }

    private static boolean isDependent(Class<? extends Entity> clazz, Class<? extends Entity> from) {
        System.out.println("\tcheck: " + clazz + " from " + from);
        return Stream.of(clazz.getDeclaredFields())
                .filter(field -> field.getDeclaredAnnotation(ForeignKey.class) != null)
                .map(field -> field.getDeclaredAnnotation(ForeignKey.class))
                .map(ForeignKey::entity)
                //.peek(c -> System.out.println("c: " + c + ", from: " + from))
                .anyMatch(c -> c.equals(from) || isDependent(c, from));
    }

}
