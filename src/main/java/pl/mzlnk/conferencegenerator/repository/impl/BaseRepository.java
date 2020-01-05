package pl.mzlnk.conferencegenerator.repository.impl;

import pl.mzlnk.conferencegenerator.entity.Identifiable;
import pl.mzlnk.conferencegenerator.repository.EntityRepository;

import java.util.*;

public abstract class BaseRepository<E extends Identifiable> implements EntityRepository<E> {

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
