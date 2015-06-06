package edu.ipsas.edt.dao;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.model.Matiere;
@Local
public interface MatiereDao extends GenericDao<Matiere>{

	Collection<Matiere> findAllMatiereByPlanEtude(long planEtudeId);

}
