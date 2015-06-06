package edu.ipsas.edt.service;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.dto.CreneauDto;
import edu.ipsas.edt.dto.EmploiDto;
import edu.ipsas.edt.dto.SeanceDto;

@Local
public interface EmploiDuTempsService {
	
		//service des creneaux
	public long addCreneau(CreneauDto creneauDto);
	public void updateCreneau(CreneauDto creneauDto);
	public void deleteCreneau(CreneauDto creneauDto);
	public Collection<CreneauDto> getAllCreneau();
	
	//services emplois
	public long addEmploi(EmploiDto emploiDto);
	public void updateEmploi(EmploiDto emploiDto);
	public EmploiDto getEmploiById(long emploiId);
	public EmploiDto getEmploiBySemestre(long semestreId);
	public Collection<EmploiDto> getAllEmploiByGroupe(long groupeId);
	public Collection<EmploiDto> getAllEmploiByAnnee(long anneeId);
	
	//les services des seances
	public long addSeance(SeanceDto seanceDto);
	public void updateSeance(SeanceDto seanceDto);
	public void moveSeance(SeanceDto seanceDto);
	public void exchangeSeance(SeanceDto seance1, SeanceDto seance2);
	public void deleteSeance(SeanceDto seanceDto);

	
}
