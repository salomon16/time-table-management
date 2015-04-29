package edu.ipsas.edt.dao;

import javax.ejb.Local;

import edu.ipsas.edt.model.Salle;

@Local
public interface SalleDao extends GenericDao<Salle>{

	public Salle findSalleByName(String name);
}
