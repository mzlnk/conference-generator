package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.Entity;
import pl.mzlnk.conferencegenerator.entity.attendee.Attendee;
import pl.mzlnk.conferencegenerator.repository.EntityRepository;

import java.util.*;

public abstract class BaseEntityRepository<E extends Entity> implements EntityRepository<E> {

    private Map<Integer, E> entities = new HashMap<>();

    @Override
    public List<E> findAll() {
        return new ArrayList<>(entities.values());
    }

    @Override
    public Optional<E> findById(int id) {
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public void createOrUpdate(E entity) {
        entities.put(entity.getId(), entity);
    }

    @Override
    public void remove(int id) {
        entities.remove(id);
    }

}
