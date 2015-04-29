package edu.ipsas.edt.service;

import java.util.Collection;

import javax.ejb.Local;

import edu.ipsas.edt.dto.CreneauDto;
import edu.ipsas.edt.dto.DepartementDto;
import edu.ipsas.edt.dto.DisponibiliteDto;
import edu.ipsas.edt.dto.EnseignantDto;
import edu.ipsas.edt.dto.GradeDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.dto.PersonnelAdministratifDto;
import edu.ipsas.edt.dto.RoleDto;
import edu.ipsas.edt.dto.CursusDto;
import edu.ipsas.edt.dto.StatutDto;
@Local
public interface EnseignantService {

	public long addCreneau(CreneauDto creneauDto);

	public void updateCreneau(CreneauDto creneauDto);

	public void deleteCreneau(CreneauDto creneauDto);

	public Collection<CreneauDto> getAllCreneau();

	public long addDisponibilite(DisponibiliteDto disponibiliteDto);

	public void updateDisponibilite(DisponibiliteDto disponibiliteDto);

	public void deleteDisponibilite(DisponibiliteDto disponibiliteDto);

	public Collection<DisponibiliteDto> getAllDisponibilite();

	public Collection<DisponibiliteDto> getAllDisponibiliteByEnseignant(
			long idEnseignant);

	public long addDepartement(DepartementDto departementDto);

	public void updateDepartement(DepartementDto departementDto);

	public void deleteDepartement(DepartementDto departementDto);

	public Collection<DepartementDto> getAllDepartement();
	
	public long addCursus(CursusDto cursusDto);

	public void updateCursus(CursusDto cursusDto);

	public void deleteCursus(CursusDto cursusDto);

	public Collection<CursusDto> getAllCursus();
	
	public Collection<CursusDto> getAllCursusByDepartement(long departementId);
	
	public Collection<EnseignantDto> getAllEnseignant(long departementId);

	public long addEnseignant(EnseignantDto enseignantDto);

	public EnseignantDto updateEnseignant(EnseignantDto enseignantDto);

	public void deleteEnseignant(EnseignantDto enseignantDto);

	public EnseignantDto getEnseignantByCode(long idEnseignant);

	public Collection<EnseignantDto> getEnseignantByFirstNameAndLastName(String nom, String prenom);
	
	public Collection<EnseignantDto> getAllEnseignant();
	
	public long addGrade(GradeDto gradeDto);

	public void deleteGrade(GradeDto gradeDto);

	public void updateGrade(GradeDto gradeDto);

	public Collection<GradeDto> getAllGrade();
	
	public GradeDto getGradeById(long idGrade);
	
	public GradeDto getGradeByName(String nom);
	
	public Collection<EnseignantDto> getAllEnseignantByGrade(long GradeId);

	public long addParcours(ParcoursDto parcoursDto);

	public void updateParcours(ParcoursDto parcoursDto);

	public void deleteParcours(ParcoursDto parcoursDto);

	public Collection<ParcoursDto> getAllParcours();

	public Collection<ParcoursDto> getParcoursBySpecialite(long idSpecialite);

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
	
	public long addRole(RoleDto role);
	
	public RoleDto getRoleById(long id);
	
	public void updateRole(RoleDto role);
	
	public Collection<RoleDto> getAllRole();

	public DepartementDto getDepartementByName(String name);

	public DepartementDto getDepartementByCode(long selectedDepartementId);

	public CursusDto getCursusByName(String cursus);

	public CursusDto getCursusById(long cursus);
	
}
