package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.PlanEtudeDao;
import edu.ipsas.edt.model.PlanEtude;
@Stateless
public class PlanEtudeImpl extends GenericDaoImpl<PlanEtude> implements PlanEtudeDao{


	 @SuppressWarnings("unchecked")
		public Collection<PlanEtude> findAll(){
	    	return em.createQuery("select p from PlanEtude p").getResultList();
	    }
	
	public PlanEtude findStudyPlanBySemesterAndParcours(long semestreId,
			long parcoursId) {
		
		return (PlanEtude) em.createQuery("select p from PlanEtude where p.semestre.semestreId=:semestreId and p.parcours.parcoursId=:parcoursId").setParameter("semestreId", semestreId).setParameter("parcoursId", parcoursId).getSingleResult();
	}

}
