package edu.ipsas.edt.service.impl;


import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.ipsas.edt.dao.CreneauDao;
import edu.ipsas.edt.dao.DisponibiliteDao;
import edu.ipsas.edt.dao.EnseignantDao;
import edu.ipsas.edt.dao.GradeDao;
import edu.ipsas.edt.dao.PersonnelAdministratifDao;
import edu.ipsas.edt.dao.RoleDao;
import edu.ipsas.edt.dao.StatutDao;
import edu.ipsas.edt.dao.VoeuxMatiereDao;
import edu.ipsas.edt.dto.DisponibiliteDto;
import edu.ipsas.edt.dto.EnseignantDto;
import edu.ipsas.edt.dto.GradeDto;
import edu.ipsas.edt.dto.PersonnelAdministratifDto;
import edu.ipsas.edt.dto.RoleDto;
import edu.ipsas.edt.dto.StatutDto;
import edu.ipsas.edt.dto.VoeuxMatiereDto;
import edu.ipsas.edt.helper.DisponibiliteHelper;
import edu.ipsas.edt.helper.EnseignantHelper;
import edu.ipsas.edt.helper.GradeHelper;
import edu.ipsas.edt.helper.PersonnelAdministratifHelper;
import edu.ipsas.edt.helper.RoleHelper;
import edu.ipsas.edt.helper.StatutHelper;
import edu.ipsas.edt.helper.VoeuxMatiereHelper;
import edu.ipsas.edt.model.Disponibilite;
import edu.ipsas.edt.model.Enseignant;
import edu.ipsas.edt.model.Grade;
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
	private PersonnelAdministratifDao personnelDao;
	@EJB 
	private RoleDao roleDao;
	@EJB
	private VoeuxMatiereDao voeuxMatiereDao;
	
	// details d'implementation des disponibilites des enseignants
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

	
	//implementation concernant les enseignants
	public long addEnseignant(EnseignantDto enseignantDto) {

		Enseignant enseignant = EnseignantHelper.dtoToModel(enseignantDto);
		enseignantDao.create(enseignant);
		return enseignant.getEnseignantID();
	}
	public Collection<EnseignantDto> getAllEnseignant() {
		
		return EnseignantHelper.modelsToDto(enseignantDao.findAll());
	}
	public Collection<EnseignantDto> getAllEnseignant(long departementId) {

		return EnseignantHelper.modelsToDto(enseignantDao
				.getAllEnseignant(departementId));
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
	public Collection<EnseignantDto> getAllEnseignantByGrade(long GradeId) {

		return EnseignantHelper.modelsToDto(enseignantDao
				.getAllEnseignantByGrade(GradeId));
	}


	// implementation concernant les grades
	public long addGrade(GradeDto gradeDto) {
		Grade grade = GradeHelper.dtoToModel(gradeDto);
		gradeDao.create(grade);

		return grade.getGradeId();
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
	public GradeDto getGradeById(long idGrade) {
		
		return GradeHelper.modelToDto(gradeDao.find(idGrade));
	}
	public GradeDto getGradeByName(String nom) {
		
		return GradeHelper.modelToDto(gradeDao.findByName(nom));
	}
	
	// implementation concernant les statuts
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
	public StatutDto getStatutById(long idStatut) {
		
		return StatutHelper.modelToDto(statutDao.find(idStatut));
	}
	public StatutDto getStatutByName(String nom) {
		
		return StatutHelper.modelToDto(statutDao.findByName(nom));
	}
	
	// details d'implementation les personnels
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
	
	// details d'implementation des roles
	public String addRole(RoleDto roleDto) {
		
		Role role = RoleHelper.dtoToModel(roleDto);
		roleDao.create(role);
		return role.getType();
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

	// details d'implementation des voeux
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
	public PersonnelAdministratifDao getPersonnelDao() {
		return personnelDao;
	}
	public void setPersonnelDao(PersonnelAdministratifDao personnelDao) {
		this.personnelDao = personnelDao;
	}
	public RoleDao getRoleDao() {
		return roleDao;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public VoeuxMatiereDao getVoeuxMatiereDao() {
		return voeuxMatiereDao;
	}
	public void setVoeuxMatiereDao(VoeuxMatiereDao voeuxMatiereDao) {
		this.voeuxMatiereDao = voeuxMatiereDao;
	}
	
	public Collection<EnseignantDto> getAllEnseignantByDepartement(
			String departementName) {
		
		return EnseignantHelper.modelsToDto(enseignantDao.findAllEnseignantByDepartement(departementName));
	}
	
}
