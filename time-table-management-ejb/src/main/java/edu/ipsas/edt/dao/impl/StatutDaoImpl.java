package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.StatutDao;
import edu.ipsas.edt.model.Statut;

@Stateless
public class StatutDaoImpl extends GenericDaoImpl<Statut> implements StatutDao {

	 @SuppressWarnings("unchecked")
		public Collection<Statut> findAll(){
	    	return em.createQuery("select s from Statut s").getResultList();
	    }

	
	public Statut findByName(String name) {
		
		return (Statut) em.createQuery("select s from Statut s where s.nom = :name").setParameter("name", name).getSingleResult();
	}
}
