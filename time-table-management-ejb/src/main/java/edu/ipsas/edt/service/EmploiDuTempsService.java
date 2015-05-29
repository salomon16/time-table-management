package edu.ipsas.edt.service;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.dto.EmploiDto;
import edu.ipsas.edt.dto.GroupeDto;
import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.dto.NiveauDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.dto.PlanEtudeDto;
import edu.ipsas.edt.dto.SeanceDto;
import edu.ipsas.edt.dto.SemestreDto;
import edu.ipsas.edt.dto.UniteDto;

@Local
public interface EmploiDuTempsService {
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
	
	public long addSemestre(SemestreDto semestreDto);
	public Collection<SemestreDto> getAllSemestre();
	
	//les services des niveaux
	public long addNiveau(NiveauDto niveauDto);
	public void updateNiveau(NiveauDto niveauDto);
	public NiveauDto getAllNiveauById(long niveauId);
	public Collection<NiveauDto> getAllNiveau();
	
	//les services des groupes
	public long addGroupe(GroupeDto groupeDto);
	public void updateGroupe(GroupeDto groupeDto);
	public void deleteGroupe(GroupeDto groupeDto);
	public Collection<GroupeDto> getAllGroupes();
	public Collection<GroupeDto> getAllGroupeByiveau(long niveauId);
	
	//les services des plans d'etude
	public long addPlanEtude(PlanEtudeDto planEtudeDto);
	public void updatePlanEtude(PlanEtudeDto planEtudeDto);
	public PlanEtudeDto getPlanEtudeById(long planEtudeId);
	public PlanEtudeDto getPlanEtudeBySemestreAndParcours(long semestreId, long parcoursId);
	public Collection<PlanEtudeDto> getAllPlanEtude();
	
	//les services des matieres
	public long addMatiere(MatiereDto matiereDto);
	public void updateMatiere(MatiereDto matiereDto);
	public void deleteMatiere(MatiereDto matiereDto);
	public Collection<MatiereDto> getAllMatiere();
	public Collection<MatiereDto> getAllMatiereByPlanEtude(long planEtudeId);
	
	//les services des unites d'enseignements
	public Collection<UniteDto> getAllUnite();
	public long addUnite(UniteDto uniteDto);
	public UniteDto getUniteById(long uniteId);
	public UniteDto getUniteByNom(String unite);
	public MatiereDto getMatiereParId(long matiereId);
	public ParcoursDto getParcoursParId(long parcoursId);
	public SemestreDto getSemestreParId(long semestreId);
	public Collection<NiveauDto> getAllNiveauByParcours(long parcoursId);
	public Collection<PlanEtudeDto> getAllPlanEtudeByParcours(long parcoursId);

}
