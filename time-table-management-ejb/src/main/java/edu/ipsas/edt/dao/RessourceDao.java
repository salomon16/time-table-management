package edu.ipsas.edt.dao;

import javax.ejb.Local;

import edu.ipsas.edt.model.Ressource;


@Local
public interface RessourceDao extends GenericDao<Ressource>{

	public Ressource findRessourceByName(String name);
}
