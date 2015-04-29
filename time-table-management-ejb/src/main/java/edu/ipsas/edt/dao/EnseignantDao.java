package edu.ipsas.edt.dao;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.model.Enseignant;

@Local
public interface EnseignantDao extends GenericDao<Enseignant> {

	Collection<Enseignant> getAllEnseignant(long departementId);

	Collection<Enseignant> getEnseignantByFirstNameAndLastName(String nom,
			String prenom);

	Collection<Enseignant> getAllEnseignantByGrade(long GradeId);

}
