package pl.mzlnk.conferencegenerator.repository;

import pl.mzlnk.conferencegenerator.entity.Identifiable;

import java.util.List;
import java.util.Optional;

public interface EntityRepository<E extends Identifiable> {

    List<E> findAll();
    Optional<E> findById(int id);
    void createOrUpdate(E entity);
    void remove(int id);

}
