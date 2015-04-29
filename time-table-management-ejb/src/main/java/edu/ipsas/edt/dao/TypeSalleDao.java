package edu.ipsas.edt.dao;

import javax.ejb.Local;

import edu.ipsas.edt.model.TypeSalle;


@Local
public interface TypeSalleDao extends GenericDao<TypeSalle>{

	public TypeSalle findTypeSalleByName(String name);
}
