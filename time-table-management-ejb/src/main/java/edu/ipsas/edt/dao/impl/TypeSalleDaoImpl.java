package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.TypeSalleDao;
import edu.ipsas.edt.model.TypeSalle;

@Stateless
public class TypeSalleDaoImpl extends GenericDaoImpl<TypeSalle> implements TypeSalleDao {
	
	 @SuppressWarnings("unchecked")
		public Collection<TypeSalle> findAll(){
	    	return em.createQuery("select t from TypeSalle t").getResultList();
	    }

	
	public TypeSalle findTypeSalleByName(String name) {
		
		return (TypeSalle) em.createQuery("select t from TypeSalle t where t.nom=:name")
				.setParameter("name",name)
				.getSingleResult();
	}
}
