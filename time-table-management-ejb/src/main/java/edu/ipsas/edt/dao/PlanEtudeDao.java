package edu.ipsas.edt.dao;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.model.PlanEtude;
@Local
public interface PlanEtudeDao extends GenericDao<PlanEtude> {

	PlanEtude findStudyPlanBySemesterAndParcours(long semestreId,
			long parcoursId);

	Collection<PlanEtude> findAllPlanEtudeByParcours(long parcoursId);

}
