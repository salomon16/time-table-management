package edu.ipsas.edt.dao;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.model.VoeuxMatiere;

@Local
public interface VoeuxMatiereDao extends GenericDao<VoeuxMatiere>{

	Collection<VoeuxMatiere> findAllVoeuxMatiereByEnseignant(long enseignantId);

}
