package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.NiveauDao;
import edu.ipsas.edt.model.Niveau;
@Stateless
public class NiveauDaoImpl extends GenericDaoImpl<Niveau> implements NiveauDao {

	 @SuppressWarnings("unchecked")
		public Collection<Niveau> findAll(){
	    	return em.createQuery("select n from Niveau n").getResultList();
	    }

	
	@SuppressWarnings("unchecked")
	public Collection<Niveau> findAllNiveauByParcours(long parcoursId) {
		
		return em.createQuery("select n from Niveau n where n.parcours.parcoursId=:parcoursId").setParameter("parcoursId", parcoursId).getResultList();
	}
}
