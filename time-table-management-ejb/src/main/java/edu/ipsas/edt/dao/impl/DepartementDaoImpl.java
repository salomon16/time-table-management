package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.DepartementDao;
import edu.ipsas.edt.model.Departement;

@Stateless
public class DepartementDaoImpl extends GenericDaoImpl<Departement> implements
		DepartementDao {
	 @SuppressWarnings("unchecked")
		public Collection<Departement> findAll(){
	    	return em.createQuery("select d from Departement d").getResultList();
	    }

	
	public Departement findByName(String name) {
		return (Departement) em.createQuery("select d from Departement d where d.nom=:name")
				.setParameter("name",name)
				.getSingleResult();
	}

}
