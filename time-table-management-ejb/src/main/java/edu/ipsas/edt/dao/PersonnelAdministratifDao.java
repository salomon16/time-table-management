package edu.ipsas.edt.dao;

import javax.ejb.Local;

import edu.ipsas.edt.model.PersonnelAdministratif;

@Local
public interface PersonnelAdministratifDao extends GenericDao<PersonnelAdministratif> {

	public PersonnelAdministratif findByLoginAndPassword(String login, String password);
	
}
