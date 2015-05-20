package edu.ipsas.edt.dao;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.model.Parcours;

@Local
public interface ParcoursDao extends GenericDao<Parcours> {

	Collection<Parcours> getParcoursBySpecialite(long idSpecialite);

	Collection<Parcours> findAllParcoursByDepartement(long departementId);
}
