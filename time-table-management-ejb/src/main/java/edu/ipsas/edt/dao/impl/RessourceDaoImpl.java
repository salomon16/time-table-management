package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.RessourceDao;
import edu.ipsas.edt.model.Ressource;

@Stateless
public class RessourceDaoImpl extends GenericDaoImpl<Ressource> implements RessourceDao {

	 @SuppressWarnings("unchecked")
		public Collection<Ressource> findAll(){
	    	return em.createQuery("select r from Ressource r").getResultList();
	    }

	
	public Ressource findRessourceByName(String name) {
		
		return null;
	}
}
