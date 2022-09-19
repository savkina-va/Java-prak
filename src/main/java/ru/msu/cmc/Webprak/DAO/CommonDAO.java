package ru.msu.cmc.Webprak.DAO;

import ru.msu.cmc.Webprak.models.CommonEntity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface CommonDAO<T extends CommonEntity<ID>, ID> {
    T getById(ID id);

    Collection<T> getAll();

    void save(T entity);

    void saveCollection(Collection<T> entities);

    void delete(T entity);

    void deleteById(ID id);

    void update(T entity);

//    List<T> filter(Map<String, List> filters, Class persistentClass);

//    public List<T> filter(Map<String,List> filters, Class persistentClass);
}