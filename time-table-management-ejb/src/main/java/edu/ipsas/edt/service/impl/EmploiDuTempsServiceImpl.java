package edu.ipsas.edt.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.ipsas.edt.dao.CreneauDao;
import edu.ipsas.edt.dao.EmploiDao;
import edu.ipsas.edt.dao.SeanceDao;
import edu.ipsas.edt.dao.VoeuxMatiereDao;
import edu.ipsas.edt.dto.CreneauDto;
import edu.ipsas.edt.dto.EmploiDto;
import edu.ipsas.edt.dto.SeanceDto;
import edu.ipsas.edt.helper.CreneauHelper;
import edu.ipsas.edt.helper.SeanceHelper;
import edu.ipsas.edt.model.Creneau;
import edu.ipsas.edt.model.Enseignant;
import edu.ipsas.edt.model.Seance;
import edu.ipsas.edt.model.VoeuxMatiere;
import edu.ipsas.edt.service.EmploiDuTempsService;

@Stateless
public class EmploiDuTempsServiceImpl implements EmploiDuTempsService {

	@EJB
	private EmploiDao emploiDao;
	@EJB
	private SeanceDao seanceDao;
	@EJB
	private CreneauDao creneauDao;
	@EJB
	private VoeuxMatiereDao voeuxMatiereDao;
	
	public long addEmploi(EmploiDto emploiDto) {
		return 0;
	}
	public void updateEmploi(EmploiDto emploiDto) {
 
	}
	public EmploiDto getEmploiById(long emploiId) {
		return null;
	}
	public EmploiDto getEmploiBySemestre(long semestreId) {
		return null;
	}
	public Collection<EmploiDto> getAllEmploiByGroupe(long groupeId) {
		return null;
	}
	public Collection<EmploiDto> getAllEmploiByAnnee(long anneeId) {
		return null;
	}
	
	public long addSeance(SeanceDto seanceDto) {
		
		Seance seance = SeanceHelper.dtoToModel(seanceDto);
		
		Enseignant enseignant = seance.getEnseignant();
//		Collection<Seance> seances = seanceDao.findAllSeanceByEnseignant(enseignant.getEnseignantID());
		Collection<VoeuxMatiere> voeuxMatieres = voeuxMatiereDao.findAllVoeuxMatiereByEnseignant(enseignant.getEnseignantId());
		
//		for(Seance currentSeance : seances){
//			if((currentSeance.getJour().equals(seance.getJour())) && (currentSeance.getCreneau().getHeureDebut() ==  seance.getCreneau().getHeureDebut()) && (currentSeance.getCreneau().getHeureFin() ==  seance.getCreneau().getHeureFin())){
//				System.out.println("Conflit de seance");
//				return -1;
//			}
//		}
//		
		for(VoeuxMatiere voeux : voeuxMatieres){
			if(!seance.getMatiere().equals(voeux.getMatiere())){
				return -1;
			}
		}
		
		seanceDao.create(seance);
		return seance.getSeanceId();
	}
	public void updateSeance(SeanceDto seanceDto) {
		seanceDao.update(SeanceHelper.dtoToModel(seanceDto));
	}
	public void moveSeance(SeanceDto seanceDto) {
	
	}
	public void exchangeSeance(SeanceDto seance1, SeanceDto seance2) {
	
	}
	public void deleteSeance(SeanceDto seanceDto) {
		seanceDao.delete(seanceDto.getSeanceId());
	}
	
	
	public long addCreneau(CreneauDto creneauDto) {

		Creneau creneau = CreneauHelper.dtoToModel(creneauDto);
		creneauDao.create(creneau);
		return creneau.getCreneauID();
	}
	public void updateCreneau(CreneauDto creneauDto) {
		creneauDao.update(CreneauHelper.dtoToModel(creneauDto));
	}

	public void deleteCreneau(CreneauDto creneauDto) {
		creneauDao.delete(creneauDto.getCreneauID());
	}
	public Collection<CreneauDto> getAllCreneau() {

		return CreneauHelper.modelsToDto(creneauDao.findAll());
	}

	
}