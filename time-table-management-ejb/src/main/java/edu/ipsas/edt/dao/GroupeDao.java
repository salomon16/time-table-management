package edu.ipsas.edt.dao;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.model.Groupe;
@Local
public interface GroupeDao extends GenericDao<Groupe> {

	Collection<Groupe> findGroupByLevel(long niveauId);

}
