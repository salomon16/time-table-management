package edu.ipsas.edt.dao;

import javax.ejb.Local;

import edu.ipsas.edt.model.Grade;

@Local
public interface GradeDao extends GenericDao<Grade>{

	public Grade findByName(String name);
	
}
