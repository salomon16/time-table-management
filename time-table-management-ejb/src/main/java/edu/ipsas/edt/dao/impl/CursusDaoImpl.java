package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.CursusDao;
import edu.ipsas.edt.model.Cursus;

@Stateless
public class CursusDaoImpl extends GenericDaoImpl<Cursus> implements CursusDao {
	 @SuppressWarnings("unchecked")
		public Collection<Cursus> findAll(){
	    	return em.createQuery("select c from Cursus c").getResultList();
	    }

	
	@SuppressWarnings("unchecked")
	public Collection<Cursus> getAllSpecialiteByDepartement(
			long departementId) {
		
		return em.createQuery("select c from Cursus c where c.departement.departementId=:departementId")
				.setParameter("departementId", departementId)
				.getResultList();
	}

	public Cursus findByName(String name) {
		
		return (Cursus) em.createQuery("select c from Cursus c where c.nom=:name").setParameter("name", name).getSingleResult();
	}
}
