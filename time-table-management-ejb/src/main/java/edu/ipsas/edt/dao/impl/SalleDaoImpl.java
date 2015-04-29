package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.SalleDao;
import edu.ipsas.edt.model.Salle;

@Stateless
public class SalleDaoImpl extends GenericDaoImpl<Salle> implements SalleDao {
	
	 @SuppressWarnings("unchecked")
		public Collection<Salle> findAll(){
	    	return em.createQuery("select s from Salle s").getResultList();
	    }

	
	public Salle findSalleByName(String name) {
		
		return null;
	}
}
