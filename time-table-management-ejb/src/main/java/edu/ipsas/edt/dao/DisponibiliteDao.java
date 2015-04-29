package edu.ipsas.edt.dao;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.model.Disponibilite;

@Local
public interface DisponibiliteDao extends GenericDao<Disponibilite> {

	Collection<Disponibilite> getAllDisponibiliteByEnseignant(long idEnseignant);
}
