package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.CreneauDao;
import edu.ipsas.edt.model.Creneau;

@Stateless
public class CreneauDaoImpl extends GenericDaoImpl<Creneau> implements CreneauDao {
	
	 @SuppressWarnings("unchecked")
		public Collection<Creneau> findAll(){
	    	return em.createQuery("select c from Creneau c order by c.ordre asc").getResultList();
	    }
}
