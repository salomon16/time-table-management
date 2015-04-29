package edu.ipsas.edt.dao;

import javax.ejb.Local;

import edu.ipsas.edt.model.Departement;

@Local
public interface DepartementDao extends GenericDao<Departement> {

	Departement findByName(String name);

}
