package edu.ipsas.edt.dao;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.model.Cursus;

@Local
public interface CursusDao extends GenericDao<Cursus>{
	
	public Collection<Cursus> getAllSpecialiteByDepartement(long departementId);

	public Cursus findByName(String cursus);
}
