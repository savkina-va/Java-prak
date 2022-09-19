package ru.msu.cmc.Webprak.DAO.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.Webprak.DAO.CommonDAO;
import ru.msu.cmc.Webprak.models.CommonEntity;

import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Filter;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public abstract class CommonDAOImpl<T extends CommonEntity<ID>, ID extends Serializable> implements CommonDAO<T, ID> {

    protected SessionFactory sessionFactory;

    protected Class<T> persistentClass;

    public CommonDAOImpl(Class<T> entityClass){
        this.persistentClass = entityClass;
    }

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory.getObject();
    }

    @Override
    public T getById(ID id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(persistentClass, id);
        }
    }

    @Override
    public Collection<T> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder().createQuery(persistentClass);
            criteriaQuery.from(persistentClass);
            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    @Override
    public void save(T entity) {
        try (Session session = sessionFactory.openSession()) {
            if (entity.getId() != null) {
                entity.setId(null);
            }
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveCollection(Collection<T> entities) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            for (T entity : entities) {
                this.save(entity);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(ID id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            T entity = getById(id);
            session.delete(entity);
            session.getTransaction().commit();
        }
    }

//    @Override
//    public List<T> filter(Map<String, List> filters, Class persistentClass) {
//
//        try (Session session = sessionFactory.openSession()){
//            filters.entrySet().forEach(entry -> {
//                String filterName = entry.getKey();
//                List parameters = entry.getValue();
//                Filter enableFilter = session.enableFilter(filterName);
//                Set<String> paramNames = enableFilter.getFilterDefinition().getParameterNames();
//                AtomicInteger i = new AtomicInteger();
//                paramNames.forEach(name ->
//                        enableFilter.setParameter(name, parameters.get(i.getAndIncrement()))
//                );
//            });
//
//            Query query = session.createQuery("from " + persistentClass.getName());
//
//            @SuppressWarnings("unchecked")
//            List<T> result = query.list();
//            session.close();
//            return result;
//        } catch (Exception e) {
//            return null;
//        }
//    }
}