package edu.ipsas.edt.dao;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.model.Niveau;
@Local
public interface NiveauDao extends GenericDao<Niveau> {

	Collection<Niveau> findAllNiveauByParcours(long parcoursID);

}
