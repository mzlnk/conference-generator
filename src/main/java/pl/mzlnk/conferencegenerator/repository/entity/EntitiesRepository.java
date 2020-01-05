package pl.mzlnk.conferencegenerator.repository.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.mzlnk.conferencegenerator.entity.Entity;
import pl.mzlnk.conferencegenerator.entity.EntityType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EntitiesRepository {

    public static EntitiesRepository init() {
        EntitiesRepository repository = new EntitiesRepository();

        repository.registerRepository(new AttendeeRepository());
        repository.registerRepository(new BuyerRepository());
        repository.registerRepository(new CompanyRepository());
        repository.registerRepository(new ConferenceDayAttendeeRepository());
        repository.registerRepository(new ConferenceDayOrderItemRepository());
        repository.registerRepository(new ConferenceDayPriceRepository());
        repository.registerRepository(new ConferenceDayRepository());
        repository.registerRepository(new ConferenceRepository());
        repository.registerRepository(new OrderRepository());
        repository.registerRepository(new StudentAttendeeRepository());
        repository.registerRepository(new WorkshopAttendeeRepository());
        repository.registerRepository(new WorkshopOrderItemRepository());
        repository.registerRepository(new WorkshopRepository());

        return repository;
    }

    private Map<EntityType, EntityRepository<? extends Entity>> repositories = new HashMap<>();

    public List<EntityRepository<? extends Entity>> getAllRepositories() {
        return new ArrayList<>(repositories.values());
    }

    public <E extends Entity> EntityRepository<E> getRepository(EntityType entityType) {
        return (EntityRepository<E>) repositories.get(entityType);
    }

    private void registerRepository(EntityRepository<? extends Entity> repository) {
        repositories.put(repository.getEntityType(), repository);
    }

}
