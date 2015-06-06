package edu.ipsas.edt.service;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.dto.DisponibiliteDto;
import edu.ipsas.edt.dto.EnseignantDto;
import edu.ipsas.edt.dto.GradeDto;
import edu.ipsas.edt.dto.PersonnelAdministratifDto;
import edu.ipsas.edt.dto.RoleDto;
import edu.ipsas.edt.dto.StatutDto;
import edu.ipsas.edt.dto.VoeuxMatiereDto;
@Local
public interface EnseignantService {

	public long addDisponibilite(DisponibiliteDto disponibiliteDto);
	public void updateDisponibilite(DisponibiliteDto disponibiliteDto);
	public void deleteDisponibilite(DisponibiliteDto disponibiliteDto);
	public Collection<DisponibiliteDto> getAllDisponibilite();
	public Collection<DisponibiliteDto> getAllDisponibiliteByEnseignant(
			long idEnseignant);

	
	public long ajouterVoeuxMatiere(VoeuxMatiereDto voeuxDto);
	public void modifierVoeuxMatiere(VoeuxMatiereDto voeuxDto);
	public void supprimerVoeuxMatiere(VoeuxMatiereDto voeuxDto);
	public Collection<VoeuxMatiereDto> obtenirToutLesVoeuxMatiere();
	public Collection<VoeuxMatiereDto> obtenirLesVoeuxMatiereParEnseignant(long enseignantId);
	

	public Collection<EnseignantDto> getAllEnseignant(long departementId);
	public long addEnseignant(EnseignantDto enseignantDto);
	public EnseignantDto updateEnseignant(EnseignantDto enseignantDto);
	public void deleteEnseignant(EnseignantDto enseignantDto);
	public EnseignantDto getEnseignantByCode(long idEnseignant);
	public Collection<EnseignantDto> getEnseignantByFirstNameAndLastName(String nom, String prenom);
	public Collection<EnseignantDto> getAllEnseignant();
	public Collection<EnseignantDto> getAllEnseignantByGrade(long GradeId);
	public Collection<EnseignantDto> getAllEnseignantByDepartement(String selectedDepartement);

	public long addGrade(GradeDto gradeDto);
	public void deleteGrade(GradeDto gradeDto);
	public void updateGrade(GradeDto gradeDto);
	public Collection<GradeDto> getAllGrade();
	public GradeDto getGradeById(long idGrade);
	public GradeDto getGradeByName(String nom);
	
	
	public long addStatut(StatutDto statutDto);
	public void deleteStatut(StatutDto statutDto);
	public void updateStatut(StatutDto statutDto);
	public StatutDto getStatutById(long idStatut);
	public StatutDto getStatutByName(String nom);
	public Collection<StatutDto> getAllStatut();

	public long addPersonnel(PersonnelAdministratifDto personnel);
	public void deletePersonnel(PersonnelAdministratifDto personnel);
	public void updatePersonnel(PersonnelAdministratifDto personnel);
	
	public PersonnelAdministratifDto getPersonnelById(long personnelId);
	public PersonnelAdministratifDto getPersonnelByLoginAndPassword(String login, String password);
	public Collection<PersonnelAdministratifDto> getAllPersonnel();
	public Collection<PersonnelAdministratifDto> getAllPersonnelByDepartement(long departementId);
	
	public String addRole(RoleDto role);
	public RoleDto getRoleById(long id);
	public void updateRole(RoleDto role);
	public Collection<RoleDto> getAllRole();

}
