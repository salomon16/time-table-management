package edu.ipsas.edt.service.impl;


import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.ipsas.edt.dao.CreneauDao;
import edu.ipsas.edt.dao.CursusDao;
import edu.ipsas.edt.dao.DepartementDao;
import edu.ipsas.edt.dao.DisponibiliteDao;
import edu.ipsas.edt.dao.EnseignantDao;
import edu.ipsas.edt.dao.GradeDao;
import edu.ipsas.edt.dao.ParcoursDao;
import edu.ipsas.edt.dao.PersonnelAdministratifDao;
import edu.ipsas.edt.dao.RoleDao;
import edu.ipsas.edt.dao.StatutDao;
import edu.ipsas.edt.dao.VoeuxMatiereDao;
import edu.ipsas.edt.dto.CreneauDto;
import edu.ipsas.edt.dto.CursusDto;
import edu.ipsas.edt.dto.DepartementDto;
import edu.ipsas.edt.dto.DisponibiliteDto;
import edu.ipsas.edt.dto.EnseignantDto;
import edu.ipsas.edt.dto.GradeDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.dto.PersonnelAdministratifDto;
import edu.ipsas.edt.dto.RoleDto;
import edu.ipsas.edt.dto.StatutDto;
import edu.ipsas.edt.dto.VoeuxMatiereDto;
import edu.ipsas.edt.helper.CreneauHelper;
import edu.ipsas.edt.helper.CursusHelper;
import edu.ipsas.edt.helper.DepartementHelper;
import edu.ipsas.edt.helper.DisponibiliteHelper;
import edu.ipsas.edt.helper.EnseignantHelper;
import edu.ipsas.edt.helper.GradeHelper;
import edu.ipsas.edt.helper.ParcoursHelper;
import edu.ipsas.edt.helper.PersonnelAdministratifHelper;
import edu.ipsas.edt.helper.RoleHelper;
import edu.ipsas.edt.helper.StatutHelper;
import edu.ipsas.edt.helper.VoeuxMatiereHelper;
import edu.ipsas.edt.model.Creneau;
import edu.ipsas.edt.model.Cursus;
import edu.ipsas.edt.model.Departement;
import edu.ipsas.edt.model.Disponibilite;
import edu.ipsas.edt.model.Enseignant;
import edu.ipsas.edt.model.Grade;
import edu.ipsas.edt.model.Parcours;
import edu.ipsas.edt.model.PersonnelAdministratif;
import edu.ipsas.edt.model.Role;
import edu.ipsas.edt.model.Statut;
import edu.ipsas.edt.model.VoeuxMatiere;
import edu.ipsas.edt.service.EnseignantService;


@Stateless
public class EnseignantServiceImpl implements EnseignantService {
	
	@EJB 
	private EnseignantDao enseignantDao;
	
	@EJB 
	private CreneauDao creneauDao;
	
	@EJB 
	private GradeDao gradeDao;
	
	@EJB 
	private StatutDao statutDao;
	
	@EJB 
	private DisponibiliteDao disponibiliteDao;
	
	@EJB 
	private DepartementDao departementDao;
	
	@EJB 
	private CursusDao cursusDao;
	
	@EJB 
	private ParcoursDao parcoursDao;

	@EJB 
	private PersonnelAdministratifDao personnelDao;
	
	@EJB 
	private RoleDao roleDao;
	
	@EJB
	private VoeuxMatiereDao voeuxMatiereDao;
	
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

	
	public long addDisponibilite(DisponibiliteDto disponibiliteDto) {
		Disponibilite disponibilite = DisponibiliteHelper
				.dtoToModel(disponibiliteDto);
		disponibiliteDao.create(disponibilite);
		return disponibilite.getDisponibiliteID();
	}

	
	public void updateDisponibilite(DisponibiliteDto disponibiliteDto) {
		disponibiliteDao.update(DisponibiliteHelper
				.dtoToModel(disponibiliteDto));
	}

	
	public void deleteDisponibilite(DisponibiliteDto disponibiliteDto) {
		disponibiliteDao.delete(disponibiliteDto.getDisponibiliteID());
	}

	
	public Collection<DisponibiliteDto> getAllDisponibilite() {

		return DisponibiliteHelper.modelsToDto(disponibiliteDao.findAll());
	}

	
	public Collection<DisponibiliteDto> getAllDisponibiliteByEnseignant(
			long idEnseignant) {

		return DisponibiliteHelper.modelsToDto(disponibiliteDao
				.getAllDisponibiliteByEnseignant(idEnseignant));
	}

	
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

	
	public Collection<DepartementDto> getAllDepartement() {

		return DepartementHelper
				.modelsToDto(departementDao.findAll());
	}

	
	public Collection<EnseignantDto> getAllEnseignant(long departementId) {

		return EnseignantHelper.modelsToDto(enseignantDao
				.getAllEnseignant(departementId));
	}

	
	public long addEnseignant(EnseignantDto enseignantDto) {

		Enseignant enseignant = EnseignantHelper.dtoToModel(enseignantDto);
		enseignantDao.create(enseignant);
		return enseignant.getEnseignantID();
	}

	
	public EnseignantDto updateEnseignant(EnseignantDto enseignantDto) {

		EnseignantDto enseignant = EnseignantHelper.modelToDto(enseignantDao.update(EnseignantHelper.dtoToModel(enseignantDto)));
		
		
		return enseignant;
	}

	
	public void deleteEnseignant(EnseignantDto enseignantDto) {
		Enseignant enseignant = enseignantDao.find(enseignantDto.getEnseignantID());
		
		if(enseignant !=null){
			enseignantDao.delete(enseignantDto.getEnseignantID());
		}
	}

	
	public EnseignantDto getEnseignantByCode(long idEnseignant) {

		return EnseignantHelper.modelToDto(enseignantDao.find(idEnseignant));
	}

	
	public Collection<EnseignantDto> getEnseignantByFirstNameAndLastName(
			String nom, String prenom) {

		return EnseignantHelper.modelsToDto(enseignantDao
				.getEnseignantByFirstNameAndLastName(nom, prenom));
	}

	
	public long addGrade(GradeDto gradeDto) {
		Grade grade = GradeHelper.dtoToModel(gradeDto);
		gradeDao.create(grade);

		return grade.getGradeID();
	}

	
	public void deleteGrade(GradeDto gradeDto) {
		gradeDao.delete(gradeDto.getGradeID());
	}

	
	public void updateGrade(GradeDto gradeDto) {
		gradeDao.update(GradeHelper.dtoToModel(gradeDto));
	}

	
	public Collection<GradeDto> getAllGrade() {

		return GradeHelper.modelsToDto(gradeDao.findAll());
	}

	
	public Collection<EnseignantDto> getAllEnseignantByGrade(long GradeId) {

		return EnseignantHelper.modelsToDto(enseignantDao
				.getAllEnseignantByGrade(GradeId));
	}

	
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

	
	public long addStatut(StatutDto statutDto) {
		Statut statut = StatutHelper.dtoToModel(statutDto);
		statutDao.create(statut);
		return statut.getStatutID();
	}

	
	public void deleteStatut(StatutDto statutDto) {
		statutDao.delete(statutDto.getStatutID());
	}

	
	public void updateStatut(StatutDto statutDto) {
		statutDao.update(StatutHelper.dtoToModel(statutDto));
	}

	
	public Collection<StatutDto> getAllStatut() {

		return StatutHelper.modelsToDto(statutDao.findAll());
	}

	public EnseignantDao getEnseignantDao() {
		return enseignantDao;
	}

	public void setEnseignantDao(EnseignantDao enseignantDao) {
		this.enseignantDao = enseignantDao;
	}

	public CreneauDao getCreneauDao() {
		return creneauDao;
	}

	public void setCreneauDao(CreneauDao creneauDao) {
		this.creneauDao = creneauDao;
	}

	public GradeDao getGradeDao() {
		return gradeDao;
	}

	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	public StatutDao getStatutDao() {
		return statutDao;
	}

	public void setStatutDao(StatutDao statutDao) {
		this.statutDao = statutDao;
	}

	public DisponibiliteDao getDisponibiliteDao() {
		return disponibiliteDao;
	}

	public void setDisponibiliteDao(DisponibiliteDao disponibiliteDao) {
		this.disponibiliteDao = disponibiliteDao;
	}

	public DepartementDao getDepartementDao() {
		return departementDao;
	}

	public void setDepartementDao(DepartementDao departementDao) {
		this.departementDao = departementDao;
	}

	public ParcoursDao getParcoursDao() {
		return parcoursDao;
	}

	public void setParcoursDao(ParcoursDao parcoursDao) {
		this.parcoursDao = parcoursDao;
	}


	public StatutDto getStatutById(long idStatut) {
		
		return StatutHelper.modelToDto(statutDao.find(idStatut));
	}


	
	public GradeDto getGradeById(long idGrade) {
		
		return GradeHelper.modelToDto(gradeDao.find(idGrade));
	}


	
	public GradeDto getGradeByName(String nom) {
		
		return GradeHelper.modelToDto(gradeDao.findByName(nom));
	}


	
	public StatutDto getStatutByName(String nom) {
		
		return StatutHelper.modelToDto(statutDao.findByName(nom));
	}


	
	public Collection<EnseignantDto> getAllEnseignant() {
		
		return EnseignantHelper.modelsToDto(enseignantDao.findAll());
	}


	
	public long addPersonnel(PersonnelAdministratifDto personnelDto) {
		PersonnelAdministratif personnel = PersonnelAdministratifHelper.dtoToModel(personnelDto);
		personnelDao.create(personnel);
		return personnel.getPersonnelId();
	}


	
	public void deletePersonnel(PersonnelAdministratifDto personnel) {
		personnelDao.delete(personnel.getPersonnelId());
	}


	public void updatePersonnel(PersonnelAdministratifDto personnel) {
		personnelDao.update(PersonnelAdministratifHelper.dtoToModel(personnel));
	}


	
	public PersonnelAdministratifDto getPersonnelById(long personnelId) {
		
		return PersonnelAdministratifHelper.modelToDto(personnelDao.find(personnelId));
	}


	
	public PersonnelAdministratifDto getPersonnelByLoginAndPassword(
			String login, String password) {
		
		return PersonnelAdministratifHelper.modelToDto(personnelDao.findByLoginAndPassword(login, password));
	}

	public Collection<PersonnelAdministratifDto> getAllPersonnel() {
	
		return PersonnelAdministratifHelper.modelsToDto(personnelDao.findAll());
	}

	public Collection<PersonnelAdministratifDto> getAllPersonnelByDepartement(
			long departementId) {
		return null;
	}

	public long addRole(RoleDto roleDto) {
		
		Role role = RoleHelper.dtoToModel(roleDto);
		roleDao.create(role);
		return role.getRoleId();
	}

	public RoleDto getRoleById(long roleId) {

		return RoleHelper.modelToDto(roleDao.find(roleId));
	}

	public void updateRole(RoleDto roleDto) {
		
		roleDao.update(RoleHelper.dtoToModel(roleDto));
	}

	public Collection<RoleDto> getAllRole() {
	
		return RoleHelper.modelsToDto(roleDao.findAll());
	}

	public long addCursus(CursusDto specialiteDto) {
			Cursus specialite = CursusHelper.dtoToModel(specialiteDto);
			cursusDao.create(specialite);
			
		return specialite.getCursusId();
	}

	public void updateCursus(CursusDto specialiteDto) {
		cursusDao.update(CursusHelper.dtoToModel(specialiteDto));
	}

	public void deleteCursus(CursusDto specialiteDto) {
		cursusDao.delete(specialiteDto.getCursusId());
	}

	public Collection<CursusDto> getAllCursus() {
		
		return CursusHelper.modelsToDto(cursusDao.findAll());
	}

	
	public DepartementDto getDepartementByName(String name) {
		
		return DepartementHelper.modelToDto(departementDao.findByName(name));
	}

	
	public Collection<CursusDto> getAllCursusByDepartement(
			long departementId) {
		
		return CursusHelper.modelsToDto(cursusDao.getAllSpecialiteByDepartement(departementId));
	}

	
	public DepartementDto getDepartementByCode(long selectedDepartementId) {
		
		return DepartementHelper.modelToDto(departementDao.find(selectedDepartementId));
	}

	
	public CursusDto getCursusByName(String cursus) {
		
		return CursusHelper.modelToDto(cursusDao.findByName(cursus));
	}

	
	public CursusDto getCursusById(long cursus) {
		
		return CursusHelper.modelToDto(cursusDao.find(cursus));
	}

	
	public long ajouterVoeuxMatiere(VoeuxMatiereDto voeuxDto) {
		VoeuxMatiere voeuxMatiere = VoeuxMatiereHelper.dtoToModel(voeuxDto);
		voeuxMatiereDao.create(voeuxMatiere);
		return voeuxMatiere.getVoeuxMatiereId();
	}

	
	public void modifierVoeuxMatiere(VoeuxMatiereDto voeuxDto) {
		voeuxMatiereDao.update(VoeuxMatiereHelper.dtoToModel(voeuxDto));
	}


	public void supprimerVoeuxMatiere(VoeuxMatiereDto voeuxDto) {
		voeuxMatiereDao.delete(voeuxDto.getVoeuxMatiereId());
	}

	
	public Collection<VoeuxMatiereDto> obtenirToutLesVoeuxMatiere() {
		
		return VoeuxMatiereHelper.modelsToDto(voeuxMatiereDao.findAll());
	}

	
	public Collection<VoeuxMatiereDto> obtenirLesVoeuxMatiereParEnseignant(
			long enseignantId) {
		
		return null;
	}

	
	public Collection<ParcoursDto> getAllParcoursByDepartement(
			long departementId) {
		
		return ParcoursHelper.modelsToDto(parcoursDao.findAllParcoursByDepartement(departementId));
	}

	
	public Collection<ParcoursDto> getAllParcoursByCursus(long cursusById) {
		
		return ParcoursHelper.modelsToDto(parcoursDao.findAllParcoursByCursus(cursusById));
	}

	
}
