package edu.ipsas.edt.dao;

import javax.ejb.Local;

import edu.ipsas.edt.model.Statut;


@Local
public interface StatutDao extends GenericDao<Statut>{

	public Statut findByName(String name);
}
