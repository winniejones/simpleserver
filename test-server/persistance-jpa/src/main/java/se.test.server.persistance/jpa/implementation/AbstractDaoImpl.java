package se.test.server.persistance.jpa.implementation;


import se.test.server.model.Address;
import se.test.server.persistance.jpa.AbstractDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDaoImpl<T extends Serializable, PK extends Serializable> implements AbstractDao<T, PK> {

    @PersistenceContext(unitName="TESTPU")
    private EntityManager em;

    private final Class<T> entityType;

    /**
     * @param type Entity type
     */
    public AbstractDaoImpl(final Class<T> type) {
        this.entityType = type;
    }

    /**
     * @return Entity manager
     */
    public final EntityManager getEm() {
        return em;
    }

    /**
     * Returns entity type.
     * @return Entity type
     */
    public final Class<T> getType() {
        return entityType;
    }

    @Override
    public final T find(final PK id) {
        return em.find(entityType, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return em.createNamedQuery("from " + entityType.getName()).getResultList();
    }

    @Override
    public final void save(final T entity) {
        em.persist(entity);
    }

    @Override
    public final void update(final T entity) {
        em.merge(entity);
    }

    @Override
    public final void delete(final T entity) {
        em.remove(entity);
    }

    @Override
    public final void deleteById(final PK id) {
        em.remove(em.find(entityType, id));
    }

    @Override
    public long count() {
        return (Long) em.createQuery("select count(*) from " + entityType.getName()).getSingleResult();
    }
}

