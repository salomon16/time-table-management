package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.SeanceDao;
import edu.ipsas.edt.model.Seance;
@Stateless
public class SeanceDaoImpl extends GenericDaoImpl<Seance> implements SeanceDao {

	 @SuppressWarnings("unchecked")
		public Collection<Seance> findAll(){
	    	return em.createQuery("select s from Seance s").getResultList();
	    }

	
	@SuppressWarnings("unchecked")
	public Collection<Seance> findAllSeanceByEnseignant(long enseignantId) {
		
		return (Collection<Seance>) em.createQuery("select s from Seance where s.enseignant.enseignantId=:enseignantId").setParameter("enseignantId", enseignantId);
	}
}
