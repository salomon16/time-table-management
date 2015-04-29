package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.PersonnelAdministratifDao;
import edu.ipsas.edt.model.PersonnelAdministratif;

@Stateless
public class PersonnelAdministratifDaoImpl extends GenericDaoImpl<PersonnelAdministratif> implements PersonnelAdministratifDao{

	
	public PersonnelAdministratif findByLoginAndPassword(String login, String password) {
		
		return (PersonnelAdministratif) em.createQuery("select p from PersonnelAdministratif p where p.login=:login and p.password=:password")
				.setParameter("login", login)
				.setParameter("password", password)
				.getSingleResult();
	}
	
	 @SuppressWarnings("unchecked")
		public Collection<PersonnelAdministratif> findAll(){
	    	return em.createQuery("select p from PersonneAdministratif p").getResultList();
	    }

	
}
