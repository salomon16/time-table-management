package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.EnseignantDao;
import edu.ipsas.edt.model.Enseignant;

@Stateless
public class EnseignantDaoImpl extends GenericDaoImpl<Enseignant> implements EnseignantDao {

	
	@SuppressWarnings("unchecked")
	public Collection<Enseignant> getAllEnseignant(long departementId) {

		return em.createQuery(" select e from Enseignant e where e.departements=(select d from Departement d where d.departementId=:departementId").setParameter("departementId", departementId).getResultList();
	}

	@SuppressWarnings("unchecked")
	public Collection<Enseignant> getEnseignantByFirstNameAndLastName(
			String nom, String prenom) {
		return em
				
				.createQuery(
						" FROM Enseignant e where e.nom = :nom AND e.prenom = :prenom")
				.setParameter("nom", nom).setParameter("prenom", prenom).getResultList();
	}

	@SuppressWarnings("unchecked")
	public Collection<Enseignant> getAllEnseignantByGrade(long gradeId) {
		return em
				
				.createQuery(
						" FROM Enseignant e where e.grades=(select OBJECT(m) from Grade where g.gradeID=:gradeId")
				.setParameter("departementId", gradeId).getResultList();
	}
	
	 @SuppressWarnings("unchecked")
		public Collection<Enseignant> findAll(){
	    	return em.createQuery("select e from Enseignant e").getResultList();
	    }

}
