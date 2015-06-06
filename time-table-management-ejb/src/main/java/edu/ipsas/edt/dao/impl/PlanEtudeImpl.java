package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.Query;

import edu.ipsas.edt.dao.PlanEtudeDao;
import edu.ipsas.edt.model.PlanEtude;
@Stateless
public class PlanEtudeImpl extends GenericDaoImpl<PlanEtude> implements PlanEtudeDao{


	 @SuppressWarnings("unchecked")
		public Collection<PlanEtude> findAll(){
	    	return em.createQuery("select p from PlanEtude p").getResultList();
	    }
	
	public PlanEtude findStudyPlanBySemesterAndParcours(long semestreId,long parcoursId) {
		
		 Query q = em.createQuery("select p from PlanEtude p where p.semestre.semestreId = :semestreId and p.parcours.parcoursId = :parcoursId");
				q.setParameter("semestreId", semestreId);
				q.setParameter("parcoursId", parcoursId);
				return (PlanEtude) q.getSingleResult();
	}

	
	@SuppressWarnings("unchecked")
	public Collection<PlanEtude> findAllPlanEtudeByParcours(long parcoursId) {
		
		return em.createQuery("select p from PlanEtude p where p.parcours.parcoursId=:parcoursId").setParameter("parcoursId", parcoursId).getResultList();
	}

}
