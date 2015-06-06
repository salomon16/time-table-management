package edu.ipsas.edt.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.ipsas.edt.dao.CursusDao;
import edu.ipsas.edt.dao.DepartementDao;
import edu.ipsas.edt.dao.GroupeDao;
import edu.ipsas.edt.dao.MatiereDao;
import edu.ipsas.edt.dao.NiveauDao;
import edu.ipsas.edt.dao.ParcoursDao;
import edu.ipsas.edt.dao.PlanEtudeDao;
import edu.ipsas.edt.dao.SemestreDao;
import edu.ipsas.edt.dao.UniteDao;
import edu.ipsas.edt.dto.CursusDto;
import edu.ipsas.edt.dto.DepartementDto;
import edu.ipsas.edt.dto.GroupeDto;
import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.dto.NiveauDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.dto.PlanEtudeDto;
import edu.ipsas.edt.dto.SemestreDto;
import edu.ipsas.edt.dto.UniteDto;
import edu.ipsas.edt.helper.CursusHelper;
import edu.ipsas.edt.helper.DepartementHelper;
import edu.ipsas.edt.helper.GroupeHelper;
import edu.ipsas.edt.helper.MatiereHelper;
import edu.ipsas.edt.helper.NiveauHelper;
import edu.ipsas.edt.helper.ParcoursHelper;
import edu.ipsas.edt.helper.PlanEtudeHelper;
import edu.ipsas.edt.helper.SemestreHelper;
import edu.ipsas.edt.helper.UniteHelper;
import edu.ipsas.edt.model.Cursus;
import edu.ipsas.edt.model.Departement;
import edu.ipsas.edt.model.Groupe;
import edu.ipsas.edt.model.Matiere;
import edu.ipsas.edt.model.Niveau;
import edu.ipsas.edt.model.Parcours;
import edu.ipsas.edt.model.PlanEtude;
import edu.ipsas.edt.model.Semestre;
import edu.ipsas.edt.model.Unite;
import edu.ipsas.edt.service.DepartementService;

@Stateless
public class DepartementServiceImpl implements DepartementService{

	@EJB 
	private DepartementDao departementDao;
	@EJB 
	private CursusDao cursusDao;
	@EJB 
	private ParcoursDao parcoursDao;
	@EJB
	private MatiereDao matiereDao;
	@EJB
	private NiveauDao niveauDao;
	@EJB
	private GroupeDao groupeDao;
	@EJB
	private SemestreDao semestreDao;
	@EJB
	private PlanEtudeDao planEtudeDao;
	@EJB
	private UniteDao uniteDao;
	

	//implementation convernant le departement
	public long addDepartement(DepartementDto departementDto) {
		Departement departement = DepartementHelper.dtoToModel(departementDto);
		departementDao.create(departement);
		return departement.getDepartementID();
	}
	public void updateDepartement(DepartementDto departementDto) {
		departementDao.update(DepartementHelper.dtoToModel(departementDto));
	}
	public void deleteDepartement(DepartementDto departementDto) {
		departementDao.delete(departementDto.getDepartementID());
	}
	public DepartementDto getDepartementByCode(long selectedDepartementId) {
		
		return DepartementHelper.modelToDto(departementDao.find(selectedDepartementId));
	}
	public Collection<DepartementDto> getAllDepartement() {

		return DepartementHelper
				.modelsToDto(departementDao.findAll());
	}
	public DepartementDto getDepartementByName(String name) {
		
		return DepartementHelper.modelToDto(departementDao.findByName(name));
	}

	//implementation convernant le parcours
	public long addParcours(ParcoursDto parcoursDto) {
		Parcours parcours = ParcoursHelper.dtoToModel(parcoursDto);
		parcoursDao.create(parcours);
		return parcours.getParcoursID();
	}
	public void updateParcours(ParcoursDto parcoursDto) {
		parcoursDao.update(ParcoursHelper.dtoToModel(parcoursDto));
	}
	public void deleteParcours(ParcoursDto parcoursDto) {
		parcoursDao.delete(parcoursDto.getParcoursId());
	}
	public Collection<ParcoursDto> getAllParcours() {

		return ParcoursHelper.modelsToDto(parcoursDao.findAll());
	}
	public Collection<ParcoursDto> getParcoursBySpecialite(long idSpecialite) {

		return ParcoursHelper.modelsToDto(parcoursDao
				.getParcoursBySpecialite(idSpecialite));
	}
	public ParcoursDto getParcoursParId(long parcoursId) {
		
		return ParcoursHelper.modelToDto(parcoursDao.find(parcoursId));
	}
	public Collection<ParcoursDto> getAllParcoursByDepartement(
			long departementId) {
		
		return ParcoursHelper.modelsToDto(parcoursDao.findAllParcoursByDepartement(departementId));
	}
	public Collection<ParcoursDto> getAllParcoursByCursus(long cursusById) {
		
		return ParcoursHelper.modelsToDto(parcoursDao.findAllParcoursByCursus(cursusById));
	}
	
	//implementation concernant les matieres
	public long addMatiere(MatiereDto matiereDto) {
		
		Matiere matiere = MatiereHelper.dtoToModel(matiereDto);
		matiereDao.create(matiere);
		
		return matiere.getMatiereId();
	}
	public MatiereDto getMatiereParId(long matiereId) {
		
		return MatiereHelper.modelToDto(matiereDao.find(matiereId));
	}
	public void updateMatiere(MatiereDto matiereDto) {
		
		matiereDao.update(MatiereHelper.dtoToModel(matiereDto));
	}
	public void deleteMatiere(MatiereDto matiereDto) {
		matiereDao.delete(matiereDto.getMatiereId());
	}
	public Collection<MatiereDto> getAllMatiere() {
		
		return MatiereHelper.modelsToDto(matiereDao.findAll());
	}
	public Collection<MatiereDto> getAllMatiereByPlanEtude(long planEtudeId) {
		
		return MatiereHelper.modelsToDto(matiereDao.findAllMatiereByPlanEtude(planEtudeId));
	}
	
	//implementation concernant le plan d'etude
	public long addPlanEtude(PlanEtudeDto planEtudeDto) {
		PlanEtude planEtude = PlanEtudeHelper.dtoToModel(planEtudeDto);
		planEtudeDao.create(planEtude);
		return planEtude.getPlanEtudeId();
	}
	public void updatePlanEtude(PlanEtudeDto planEtudeDto) {
		planEtudeDao.update(PlanEtudeHelper.dtoToModel(planEtudeDto));
	}
	public Collection<PlanEtudeDto> getAllPlanEtudeByParcours(long parcoursId) {
		
		return PlanEtudeHelper.modelsToDto(planEtudeDao.findAllPlanEtudeByParcours(parcoursId));
	}
	public PlanEtudeDto getPlanEtudeById(long planEtudeId) {
		
		return PlanEtudeHelper.modelToDto(planEtudeDao.find(planEtudeId));
	}
	public PlanEtudeDto getPlanEtudeBySemestreAndParcours(long semestreId,long parcoursId) {
		
		return PlanEtudeHelper.modelToDto(planEtudeDao.findStudyPlanBySemesterAndParcours(semestreId,parcoursId));
	}
	public Collection<PlanEtudeDto> getAllPlanEtude() {
		
		return PlanEtudeHelper.modelsToDto(planEtudeDao.findAll());
	}
	
	//implementation concernant les niveaux
	public long addNiveau(NiveauDto niveauDto) {
		Niveau niveau = NiveauHelper.dtoToModel(niveauDto);
		niveauDao.create(niveau);
		return niveau.getNiveauId();
	}
	public Collection<NiveauDto> getAllNiveauByParcours(long parcoursId) {
		
		return NiveauHelper.modelsToDto(niveauDao.findAllNiveauByParcours(parcoursId));
	}
	
	public void updateNiveau(NiveauDto niveauDto) {
		niveauDao.update(NiveauHelper.dtoToModel(niveauDto));
	}
	public NiveauDto getAllNiveauById(long niveauId) {
		
		return NiveauHelper.modelToDto(niveauDao.find(niveauId));
	}
	public Collection<NiveauDto> getAllNiveau() {
		
		return NiveauHelper.modelsToDto(niveauDao.findAll());
	}
	
	//implementation concernant les groupes
	public long addGroupe(GroupeDto groupeDto) {
		Groupe groupe = GroupeHelper.dtoToModel(groupeDto);
		groupeDao.create(groupe);
		return groupe.getGroupeId();
	}
	public void updateGroupe(GroupeDto groupeDto) {
		groupeDao.update(GroupeHelper.dtoToModel(groupeDto));
	}
	public void deleteGroupe(GroupeDto groupeDto) {
		groupeDao.delete(groupeDto.getGroupeId());
	}
	public Collection<GroupeDto> getAllGroupes() {
		
		return GroupeHelper.modelsToDto(groupeDao.findAll());
	}
	public Collection<GroupeDto> getAllGroupeByiveau(long niveauId) {
		
		return GroupeHelper.modelsToDto(groupeDao.findGroupByLevel(niveauId));
	}
	
	//implementation concernant les unites d'enseignement
	public Collection<UniteDto> getAllUnite() {
		
		return UniteHelper.modelsToDto(uniteDao.findAll());
	}
	public long addUnite(UniteDto uniteDto) {
		Unite unite = UniteHelper.dtoToModel(uniteDto);
		uniteDao.create(unite);
		return unite.getUniteId() ;
	}
	public UniteDto getUniteById(long id) {
		
		return UniteHelper.modelToDto(uniteDao.find(id));
	}
	public UniteDto getUniteByNom(String nom) {
		
		return UniteHelper.modelToDto(uniteDao.findUniteByName(nom));
	}
	
	//implementation concernant les semestres
	public long addSemestre(SemestreDto semestreDto) {
		
		Semestre semestre = SemestreHelper.dtoToModel(semestreDto);
		semestreDao.create(semestre);
		return semestre.getSemestreId();
	}
	public Collection<SemestreDto> getAllSemestre() {
		return SemestreHelper.modelsToDto(semestreDao.findAll());
	}
	public SemestreDto getSemestreParId(long semestreId) {
		return SemestreHelper.modelToDto(semestreDao.find(semestreId));
	}
	
	
	
	public long addCursus(CursusDto cursusDto) {
		Cursus cursus = CursusHelper.dtoToModel(cursusDto);
		cursusDao.create(cursus);
		return cursus.getCursusId();
	}

	public void updateCursus(CursusDto cursusDto) {
		cursusDao.update(CursusHelper.dtoToModel(cursusDto));
	}
	public void deleteCursus(CursusDto cursusDto) {
		cursusDao.delete(cursusDto.getCursusId());
	}
	public Collection<CursusDto> getAllCursus() {
		
		return CursusHelper.modelsToDto(cursusDao.findAll());
	}
	public CursusDto getCursusByName(String cursus) {
		
		return CursusHelper.modelToDto(cursusDao.findByName(cursus));
	}
	public CursusDto getCursusById(long cursus) {
		
		return CursusHelper.modelToDto(cursusDao.find(cursus));
	}
	public Collection<CursusDto> getAllCursusByDepartement(
			long departementId) {
		
		return CursusHelper.modelsToDto(cursusDao.getAllSpecialiteByDepartement(departementId));
	}

	public Collection<GroupeDto> getAllGroupeByParcours(long parcoursId) {
		
		return GroupeHelper.modelsToDto(groupeDao.findAllGroupeByParcours(parcoursId));
	}
}
