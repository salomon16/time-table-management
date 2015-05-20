package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.VoeuxMatiereDao;
import edu.ipsas.edt.model.VoeuxMatiere;

@Stateless
public class VoeuxMatiereDaoImpl extends GenericDaoImpl<VoeuxMatiere> implements VoeuxMatiereDao{


	@SuppressWarnings("unchecked")
	public Collection<VoeuxMatiere> findAllVoeuxMatiereByEnseignant(
			long enseignantId) {
		
		return em.createQuery("select v from VoeuxMatiere where v.enseignant.enseignantId=:enseignantId").setParameter("enseignantId", enseignantId).getResultList();
	}

}
