package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.UniteDao;
import edu.ipsas.edt.model.Unite;
@Stateless
public class UniteDaoImpl extends GenericDaoImpl<Unite> implements UniteDao{

	@SuppressWarnings("unchecked")
	public Collection<Unite> findAll(){
    	return em.createQuery("select u from Unite u").getResultList();
    }

	
	public Unite findUniteByName(String name) {
		
		return (Unite) em.createQuery("select u from Unite u where u.nom=:nom").setParameter("nom",name).getSingleResult();
	}


}
