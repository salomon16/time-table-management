package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.GradeDao;
import edu.ipsas.edt.model.Grade;

@Stateless
public class GradeDaoImpl extends GenericDaoImpl<Grade> implements GradeDao {
	
	 @SuppressWarnings("unchecked")
		public Collection<Grade> findAll(){
	    	return em.createQuery("select g from Grade g").getResultList();
	    }

	
	public Grade findByName(String name) {
		
		return (Grade) em.createQuery("select g from Grade g where g.nom  = :name").setParameter("name", name).getSingleResult();
	}
}
