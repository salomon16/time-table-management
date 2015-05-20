package edu.ipsas.edt.dao;

import javax.ejb.Local;

import edu.ipsas.edt.model.PlanEtude;
@Local
public interface PlanEtudeDao extends GenericDao<PlanEtude> {

	PlanEtude findStudyPlanBySemesterAndParcours(long semestreId,
			long parcoursId);

}
