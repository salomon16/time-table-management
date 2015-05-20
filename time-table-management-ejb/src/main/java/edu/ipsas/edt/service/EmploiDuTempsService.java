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
	public long creerEmploi(EmploiDto emploiDto);
	public void modifierEmploi(EmploiDto emploiDto);
	public EmploiDto afficherEmploi(long emploiId);
	public EmploiDto afficherEmploiParSemestre(long semestreId);
	public Collection<EmploiDto> obtenirLesEmploisParGroupe(long groupeId);
	public Collection<EmploiDto> obtenirLesEmploisParAnnee(long anneeId);
	
	
	public long creerSeance(SeanceDto seanceDto);
	public void modifierSeance(SeanceDto seanceDto);
	public void deplacerSeance(SeanceDto seanceDto);
	public void echangerSeances(SeanceDto seance1, SeanceDto seance2);
	public void supprimerSeance(SeanceDto seanceDto);
	
	public long ajouterSemestre(SemestreDto semestreDto);
	public Collection<SemestreDto> afficherLesSemestres();
	
	//les services des niveaux
	public long ajouterNiveau(NiveauDto niveauDto);
	public void modiferNiveau(NiveauDto niveauDto);
	public NiveauDto obtenirNiveauParId(long niveauId);
	public Collection<NiveauDto> afficherLesNiveaux();
	
	//les services des groupes
	public long ajouterGroupe(GroupeDto groupeDto);
	public void modifierGroupe(GroupeDto groupeDto);
	public void supprimerGroupe(GroupeDto groupeDto);
	public Collection<GroupeDto> afficherLesGroupes();
	public Collection<GroupeDto> obtenirLesGroupesParNiveau(long niveauId);
	
	//les services des plans d'etude
	public long ajouterPlanEtude(PlanEtudeDto planEtudeDto);
	public void modifierPlanEtude(PlanEtudeDto planEtudeDto);
	public PlanEtudeDto afficherPlanEtude(long planEtudeId);
	public PlanEtudeDto afficherPlanEtudeParSemestreEtParcours(long semestreId, long parcoursId);
	public Collection<PlanEtudeDto> obtenirLesPlansEtude();
	
	//les services des matieres
	public long ajouterMatiere(MatiereDto matiereDto);
	public void modifierMatiere(MatiereDto matiereDto);
	public void supprimerMatiere(MatiereDto matiereDto);
	public Collection<MatiereDto> obtenirLesMatieres();
	public Collection<MatiereDto> afficherMatiereParPlanEtude(long planEtudeId);
	
	//les services des unites d'enseignements
	public Collection<UniteDto> obtenirLesUnites();
	public long addUnite(UniteDto uniteDto);
	public UniteDto obtenirUniteParId(long uniteId);
	public UniteDto obtenirUniteParNom(String unite);
	public MatiereDto obtenirMatiereParId(long matiereId);
	public ParcoursDto obtenirParcoursParId(long parcoursId);
	public SemestreDto obtenirSemestreParId(long semestreId);
	public Collection<NiveauDto> obtenirLesNiveauxParParcours(long parcoursID);

}
