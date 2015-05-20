package edu.ipsas.edt.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.ipsas.edt.dao.EmploiDao;
import edu.ipsas.edt.dao.GroupeDao;
import edu.ipsas.edt.dao.MatiereDao;
import edu.ipsas.edt.dao.NiveauDao;
import edu.ipsas.edt.dao.ParcoursDao;
import edu.ipsas.edt.dao.PlanEtudeDao;
import edu.ipsas.edt.dao.SeanceDao;
import edu.ipsas.edt.dao.SemestreDao;
import edu.ipsas.edt.dao.UniteDao;
import edu.ipsas.edt.dao.VoeuxMatiereDao;
import edu.ipsas.edt.dto.EmploiDto;
import edu.ipsas.edt.dto.GroupeDto;
import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.dto.NiveauDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.dto.PlanEtudeDto;
import edu.ipsas.edt.dto.SeanceDto;
import edu.ipsas.edt.dto.SemestreDto;
import edu.ipsas.edt.dto.UniteDto;
import edu.ipsas.edt.helper.GroupeHelper;
import edu.ipsas.edt.helper.MatiereHelper;
import edu.ipsas.edt.helper.NiveauHelper;
import edu.ipsas.edt.helper.ParcoursHelper;
import edu.ipsas.edt.helper.PlanEtudeHelper;
import edu.ipsas.edt.helper.SeanceHelper;
import edu.ipsas.edt.helper.SemestreHelper;
import edu.ipsas.edt.helper.UniteHelper;
import edu.ipsas.edt.model.Enseignant;
import edu.ipsas.edt.model.Groupe;
import edu.ipsas.edt.model.Matiere;
import edu.ipsas.edt.model.Niveau;
import edu.ipsas.edt.model.PlanEtude;
import edu.ipsas.edt.model.Seance;
import edu.ipsas.edt.model.Semestre;
import edu.ipsas.edt.model.Unite;
import edu.ipsas.edt.model.VoeuxMatiere;
import edu.ipsas.edt.service.EmploiDuTempsService;

@Stateless
public class EmploiDuTempsServiceImpl implements EmploiDuTempsService {

	@EJB
	private EmploiDao emploiDao;
	@EJB
	private MatiereDao matiereDao;
	@EJB
	private SemestreDao semestreDao;
	@EJB
	private PlanEtudeDao planEtudeDao;
	@EJB
	private SeanceDao seanceDao;
	@EJB
	private NiveauDao niveauDao;
	@EJB
	private GroupeDao groupeDao;
	@EJB
	private VoeuxMatiereDao voeuxMatiereDao;
	@EJB
	private UniteDao uniteDao;
	@EJB
	private ParcoursDao parcoursDao;
	
	public long creerEmploi(EmploiDto emploiDto) {
		return 0;
	}
	public void modifierEmploi(EmploiDto emploiDto) {

	}
	public EmploiDto afficherEmploi(long emploiId) {
		return null;
	}
	public EmploiDto afficherEmploiParSemestre(long semestreId) {
		return null;
	}
	public Collection<EmploiDto> obtenirLesEmploisParGroupe(long groupeId) {
		return null;
	}
	public Collection<EmploiDto> obtenirLesEmploisParAnnee(long anneeId) {
		return null;
	}
	
	public long ajouterMatiere(MatiereDto matiereDto) {
		
		Matiere matiere = MatiereHelper.dtoToModel(matiereDto);
		matiereDao.create(matiere);
		
		return matiere.getMatiereId();
	}
	
	public void modifierMatiere(MatiereDto matiereDto) {
		
		matiereDao.update(MatiereHelper.dtoToModel(matiereDto));
	}
	
	public void supprimerMatiere(MatiereDto matiereDto) {
		matiereDao.delete(matiereDto.getMatiereId());
	}
	
	public Collection<MatiereDto> obtenirLesMatieres() {
		
		return MatiereHelper.modelsToDto(matiereDao.findAll());
	}
	
	public Collection<MatiereDto> afficherMatiereParPlanEtude(long planEtudeId) {
		
		return null;
	}
	
	public long ajouterSemestre(SemestreDto semestreDto) {
		
		Semestre semestre = SemestreHelper.dtoToModel(semestreDto);
		semestreDao.create(semestre);
		return semestre.getSemestreId();
	}
	
	public Collection<SemestreDto> afficherLesSemestres() {
		return SemestreHelper.modelsToDto(semestreDao.findAll());
	}
	
	public long ajouterPlanEtude(PlanEtudeDto planEtudeDto) {
		PlanEtude planEtude = PlanEtudeHelper.dtoToModel(planEtudeDto);
		planEtudeDao.create(planEtude);
		return planEtude.getPlanEtudeId();
	}
	
	public void modifierPlanEtude(PlanEtudeDto planEtudeDto) {
		planEtudeDao.update(PlanEtudeHelper.dtoToModel(planEtudeDto));
	}
	
	public PlanEtudeDto afficherPlanEtude(long planEtudeId) {
		
		return PlanEtudeHelper.modelToDto(planEtudeDao.find(planEtudeId));
	}
	
	public PlanEtudeDto afficherPlanEtudeParSemestreEtParcours(long semestreId,
			long parcoursId) {
		
		return PlanEtudeHelper.modelToDto(planEtudeDao.findStudyPlanBySemesterAndParcours(semestreId,parcoursId));
	}
	
	public Collection<PlanEtudeDto> obtenirLesPlansEtude() {
		
		return PlanEtudeHelper.modelsToDto(planEtudeDao.findAll());
	}
	
	public long creerSeance(SeanceDto seanceDto) {
		
		Seance seance = SeanceHelper.dtoToModel(seanceDto);
		
		Enseignant enseignant = seance.getEnseignant();
		Collection<Seance> seances = seanceDao.findAllSeanceByEnseignant(enseignant.getEnseignantID());
		Collection<VoeuxMatiere> voeuxMatieres = voeuxMatiereDao.findAllVoeuxMatiereByEnseignant(enseignant.getEnseignantId());
		
		for(Seance currentSeance : seances){
			if((currentSeance.getJour().equals(seance.getJour())) && (currentSeance.getCreneau().getHeureDebut() ==  seance.getCreneau().getHeureDebut()) && (currentSeance.getCreneau().getHeureFin() ==  seance.getCreneau().getHeureFin())){
				System.out.println("Conflit de seance");
				return -1;
			}
		}
		
		for(VoeuxMatiere voeux : voeuxMatieres){
			if(!seance.getMatiere().equals(voeux.getMatiere())){
				return -1;
			}
		}
		
		seanceDao.create(seance);
		return seance.getSeanceId();
	}
	
	
	public void modifierSeance(SeanceDto seanceDto) {
		seanceDao.update(SeanceHelper.dtoToModel(seanceDto));
	}
	
	public void deplacerSeance(SeanceDto seanceDto) {
	
	}
	
	public void echangerSeances(SeanceDto seance1, SeanceDto seance2) {
	
	}
	
	public void supprimerSeance(SeanceDto seanceDto) {
		seanceDao.delete(seanceDto.getSeanceId());
	}
	
	public long ajouterNiveau(NiveauDto niveauDto) {
		Niveau niveau = NiveauHelper.dtoToModel(niveauDto);
		niveauDao.create(niveau);
		return niveau.getNiveauId();
	}

	public void modiferNiveau(NiveauDto niveauDto) {
		niveauDao.update(NiveauHelper.dtoToModel(niveauDto));
	}
	
	public NiveauDto obtenirNiveauParId(long niveauId) {
		
		return NiveauHelper.modelToDto(niveauDao.find(niveauId));
	}
	
	public Collection<NiveauDto> afficherLesNiveaux() {
		
		return NiveauHelper.modelsToDto(niveauDao.findAll());
	}
	
	public long ajouterGroupe(GroupeDto groupeDto) {
		Groupe groupe = GroupeHelper.dtoToModel(groupeDto);
		groupeDao.create(groupe);
		return groupe.getGroupeId();
	}
	
	public void modifierGroupe(GroupeDto groupeDto) {
		groupeDao.update(GroupeHelper.dtoToModel(groupeDto));
	}
	
	public void supprimerGroupe(GroupeDto groupeDto) {
		groupeDao.delete(groupeDto.getGroupeId());
	}
	
	public Collection<GroupeDto> afficherLesGroupes() {
		
		return GroupeHelper.modelsToDto(groupeDao.findAll());
	}
	
	public Collection<GroupeDto> obtenirLesGroupesParNiveau(long niveauId) {
		
		return GroupeHelper.modelsToDto(groupeDao.findGroupByLevel(niveauId));
	}
	
	public Collection<UniteDto> obtenirLesUnites() {
		
		return UniteHelper.modelsToDto(uniteDao.findAll());
	}
	
	public long addUnite(UniteDto uniteDto) {
		Unite unite = UniteHelper.dtoToModel(uniteDto);
		uniteDao.create(unite);
		return unite.getUniteId() ;
	}
	
	public UniteDto obtenirUniteParId(long id) {
		
		return UniteHelper.modelToDto(uniteDao.find(id));
	}
	
	public UniteDto obtenirUniteParNom(String nom) {
		
		return UniteHelper.modelToDto(uniteDao.findUniteByName(nom));
	}
	
	public MatiereDto obtenirMatiereParId(long matiereId) {
		
		return MatiereHelper.modelToDto(matiereDao.find(matiereId));
	}
	public ParcoursDto obtenirParcoursParId(long parcoursId) {
		
		return ParcoursHelper.modelToDto(parcoursDao.find(parcoursId));
	}
	public SemestreDto obtenirSemestreParId(long semestreId) {
		return SemestreHelper.modelToDto(semestreDao.find(semestreId));
	}
	
	public Collection<NiveauDto> obtenirLesNiveauxParParcours(long parcoursId) {
		
		return NiveauHelper.modelsToDto(niveauDao.findAllNiveauByParcours(parcoursId));
	}


}