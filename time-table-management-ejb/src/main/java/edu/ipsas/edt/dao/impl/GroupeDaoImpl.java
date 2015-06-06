package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.GroupeDao;
import edu.ipsas.edt.model.Groupe;
@Stateless
public class GroupeDaoImpl extends GenericDaoImpl<Groupe> implements GroupeDao{

	 @SuppressWarnings("unchecked")
		public Collection<Groupe> findAll(){
	    	return em.createQuery("select g from Groupe g").getResultList();
	    }

	@SuppressWarnings("unchecked")
	public Collection<Groupe> findGroupByLevel(long niveauId) {
		
		return em.createQuery("select g from Groupe where g.niveau.niveauId=:niveauId").setParameter("niveauId", niveauId).getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public Collection<Groupe> findAllGroupeByParcours(long parcoursId) {
		
		return em.createQuery("select g from Groupe g where g.niveau.parcours.parcoursId=:parcoursId").setParameter("parcoursId", parcoursId).getResultList();
	}

}
