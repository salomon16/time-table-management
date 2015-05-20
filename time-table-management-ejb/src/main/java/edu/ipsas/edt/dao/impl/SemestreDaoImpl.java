package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.SemestreDao;
import edu.ipsas.edt.model.Semestre;
@Stateless
public class SemestreDaoImpl extends GenericDaoImpl<Semestre> implements SemestreDao{
	 @SuppressWarnings("unchecked")
		public Collection<Semestre> findAll(){
	    	return em.createQuery("select s from Semestre s").getResultList();
	    }
}
