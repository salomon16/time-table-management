package edu.ipsas.edt.dao;

import java.util.Collection;

import edu.ipsas.edt.model.Seance;

public interface SeanceDao extends GenericDao<Seance>{

	Collection<Seance> findAllSeanceByEnseignant(long enseignantId);

}
