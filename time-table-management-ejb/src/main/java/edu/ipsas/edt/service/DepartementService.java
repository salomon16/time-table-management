package edu.ipsas.edt.service;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.dto.CursusDto;
import edu.ipsas.edt.dto.DepartementDto;
import edu.ipsas.edt.dto.GroupeDto;
import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.dto.NiveauDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.dto.PlanEtudeDto;
import edu.ipsas.edt.dto.SemestreDto;
import edu.ipsas.edt.dto.UniteDto;

@Local
public interface DepartementService {

	public long addDepartement(DepartementDto departementDto);
		public void updateDepartement(DepartementDto departementDto);
		public void deleteDepartement(DepartementDto departementDto);
		public Collection<DepartementDto> getAllDepartement();
		public DepartementDto getDepartementByName(String name);
		public DepartementDto getDepartementByCode(long selectedDepartementId);
		
		public long addCursus(CursusDto cursusDto);
		public void updateCursus(CursusDto cursusDto);
		public void deleteCursus(CursusDto cursusDto);
		public Collection<CursusDto> getAllCursus();
		public Collection<CursusDto> getAllCursusByDepartement(long departementId);
		public CursusDto getCursusByName(String cursus);
		public CursusDto getCursusById(long cursus);

		
		public long addParcours(ParcoursDto parcoursDto);
		public void updateParcours(ParcoursDto parcoursDto);
		public void deleteParcours(ParcoursDto parcoursDto);
		public Collection<ParcoursDto> getAllParcours();
		public Collection<ParcoursDto> getParcoursBySpecialite(long idSpecialite);
		public Collection<ParcoursDto> getAllParcoursByDepartement(long departementID);
		public Collection<ParcoursDto> getAllParcoursByCursus(long cursusById);
	
	
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

		public long addSemestre(SemestreDto semestreDto);
		public Collection<SemestreDto> getAllSemestre();
		public Collection<GroupeDto> getAllGroupeByParcours(long parcoursId);
}
