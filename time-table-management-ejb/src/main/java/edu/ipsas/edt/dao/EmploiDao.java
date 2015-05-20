package edu.ipsas.edt.dao;

import java.util.Collection;

import edu.ipsas.edt.model.Emploi;

public interface EmploiDao extends GenericDao<Emploi>{

	public Emploi EmploiParSemestre(long semestreId, long groupeId);
	public Collection<Emploi> findAllEmploiByGroup(long groupeId);
	public Collection<Emploi> findAllEmploisByYear(long anneeId);
}
