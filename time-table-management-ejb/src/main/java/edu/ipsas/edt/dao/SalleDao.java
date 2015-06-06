package edu.ipsas.edt.dao;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.model.Salle;

@Local
public interface SalleDao extends GenericDao<Salle>{

	public Salle findSalleByName(String name);

	public Collection<Salle> findAllSalleByDepartement(String departementName);
}
