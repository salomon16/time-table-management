package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.ParcoursDao;
import edu.ipsas.edt.model.Parcours;

@Stateless
public class ParcoursDaoImpl extends GenericDaoImpl<Parcours> implements ParcoursDao {


	
	@SuppressWarnings("unchecked")
	public Collection<Parcours> getParcoursBySpecialite(long idSpecialite) {
		
		return em.createQuery(
				" FROM Parcours p where p.specialite=(select OBJECT(s) from Specialite where s.specialiteId=:idspecialite")
		.setParameter("departementId", idSpecialite).getResultList();
	}
	
	 @SuppressWarnings("unchecked")
		public Collection<Parcours> findAll(){
	    	return em.createQuery("select p from Parcours p").getResultList();
	    }
}
