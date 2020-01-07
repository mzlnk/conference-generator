package pl.mzlnk.conferencegenerator.generator.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.mzlnk.conferencegenerator.generator.entity.utils.comparator.EntityGeneratorDependencyComparator;

import java.util.Set;
import java.util.TreeSet;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EntityGenerators {

    public static EntityGenerators init() {
        EntityGenerators generators = new EntityGenerators();

        generators.registerGenerator(new AttendeeGenerator());
        generators.registerGenerator(new BuyerGenerator());
        generators.registerGenerator(new CompanyGenerator());
        generators.registerGenerator(new ConferenceDayAttendeeGenerator());
        generators.registerGenerator(new ConferenceDayGenerator());
        generators.registerGenerator(new ConferenceDayOrderItemGenerator());
        generators.registerGenerator(new ConferenceDayPriceGenerator());
        generators.registerGenerator(new OrderGenerator());
        generators.registerGenerator(new StudentAttendeeGenerator());
        generators.registerGenerator(new WorkshopAttendeeGenerator());
        generators.registerGenerator(new WorkshopOrderItemGenerator());

        return generators;
    }

    private Set<EntityGenerator> generators = new TreeSet<>(new EntityGeneratorDependencyComparator());

    public void generate() {
        this.generators.forEach(EntityGenerator::generate);
    }

    private void registerGenerator(EntityGenerator generator) {
        generators.add(generator);
    }

}
