package edu.ipsas.edt.dao.impl;



import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.ipsas.edt.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @PersistenceContext(name="timetable")
    protected EntityManager em;

    private Class<T> type;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

  
    public long countAll() {

        final StringBuffer queryString = new StringBuffer(
                "SELECT count(o) from ");

        queryString.append(type.getSimpleName()).append(" o ");

        final Query query = this.em.createQuery(queryString.toString());

        return (Long) query.getSingleResult();

    }

   
    public T create(final T t) {
        this.em.persist(t);
        return t;
    }

   
    public void delete(final Object id) {
        this.em.remove(this.em.getReference(type, id));
    }

   
    public T find(final Object id) {
        return (T) this.em.find(type, id);
    }

  
    public T update(final T t) {
        return this.em.merge(t);    
    }
    
    @SuppressWarnings("unchecked")
	public Collection<T> findAll(){
    	return em.createQuery("select t from T t").getResultList();
    }
}
