package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.DisponibiliteDao;
import edu.ipsas.edt.model.Disponibilite;

@Stateless
public class DisponibiliteDaoImpl extends GenericDaoImpl<Disponibilite> implements DisponibiliteDao {

	@SuppressWarnings("unchecked")
	public Collection<Disponibilite> getAllDisponibiliteByEnseignant(
			long idEnseignant) {
		return em
				
				.createQuery(
						"FROM Disponibilite D WHERE D.enseignant.enseignantID = :idEnseignant")
				.setParameter("idEnseignant", idEnseignant).getResultList();
	}
	
	 @SuppressWarnings("unchecked")
		public Collection<Disponibilite> findAll(){
	    	return em.createQuery("select d from Disponibilite d").getResultList();
	    }

}
