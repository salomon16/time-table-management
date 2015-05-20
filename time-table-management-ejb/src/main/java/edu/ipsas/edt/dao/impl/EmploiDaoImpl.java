package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.EmploiDao;
import edu.ipsas.edt.model.Emploi;

@Stateless
public class EmploiDaoImpl extends GenericDaoImpl<Emploi> implements EmploiDao{
	
	@SuppressWarnings("unchecked")
	public Collection<Emploi> findAll(){
    	return em.createQuery("select e from Emploi e").getResultList();
    }
	public Emploi EmploiParSemestre(long semestreId, long groupeId) {
		
		return (Emploi) em.createQuery("select e from Emploi where e.semestre.semestreId=:semestreId and e.groupe.groupeId=:groupeId").setParameter("semestreId", semestreId).setParameter("groupeId", groupeId).getSingleResult();
	}
	@SuppressWarnings("unchecked")
	public Collection<Emploi> findAllEmploiByGroup(long groupeId) {
		
		return em.createQuery("select e from Emploi where e.groupe.groupeId=:groupeId").setParameter("groupeId",groupeId).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Emploi> findAllEmploisByYear(long anneeId) {
		
		return em.createQuery("select e from Emploi where e.anneeAcademique.anneeId=:anneeId").setParameter("anneeId",anneeId).getResultList();
	}
}
