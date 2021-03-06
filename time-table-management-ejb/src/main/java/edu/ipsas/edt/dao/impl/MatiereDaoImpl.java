package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.MatiereDao;
import edu.ipsas.edt.model.Matiere;
@Stateless
public class MatiereDaoImpl extends GenericDaoImpl<Matiere> implements MatiereDao {


	 @SuppressWarnings("unchecked")
		public Collection<Matiere> findAll(){
	    	return em.createQuery("select m from Matiere m").getResultList();
	    }

	
	@SuppressWarnings("unchecked")
	public Collection<Matiere> findAllMatiereByPlanEtude(long planEtudeId) {
		
		return em.createQuery("select m from Matiere m where m.plansEtude=(select p from PlanEtude p where p.planEtudeId=:planEtudeId)").setParameter("planEtudeId", planEtudeId).getResultList();
	}
}
