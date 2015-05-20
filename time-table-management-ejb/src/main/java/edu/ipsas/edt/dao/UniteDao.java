package edu.ipsas.edt.dao;

import javax.ejb.Local;

import edu.ipsas.edt.model.Unite;
@Local
public interface UniteDao extends GenericDao<Unite> {

	Unite findUniteByName(String nom);
}
