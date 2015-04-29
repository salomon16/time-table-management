package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.PersonnelAdministratifDto;
import edu.ipsas.edt.model.PersonnelAdministratif;

public class PersonnelAdministratifHelper {

public static PersonnelAdministratif dtoToModel(PersonnelAdministratifDto personnelAdministratifDto) {
		
		if(personnelAdministratifDto == null)
			return null;
		
		PersonnelAdministratif personnelAdministratif = new PersonnelAdministratif();
		personnelAdministratif.setPersonnelId(personnelAdministratifDto.getPersonnelId());
		personnelAdministratif.setNom(personnelAdministratifDto.getNom());
		personnelAdministratif.setPrenom(personnelAdministratifDto.getPrenom());
		personnelAdministratif.setCin(personnelAdministratifDto.getCin());
		personnelAdministratif.setAdresse(personnelAdministratifDto.getAdresse());
		personnelAdministratif.setEmail(personnelAdministratifDto.getEmail());
		personnelAdministratif.setLogin(personnelAdministratifDto.getLogin());
		personnelAdministratif.setPassword(personnelAdministratifDto.getPassword());
		personnelAdministratif.setTelephoneMobile(personnelAdministratifDto.getTelephoneMobile());
		personnelAdministratif.setFonction(personnelAdministratifDto.getFonction());
		personnelAdministratif.setTelFixe(personnelAdministratifDto.getTelephoneMobile());
		personnelAdministratif.setDepartement(DepartementHelper.dtoToModel(personnelAdministratifDto
				.getDepartementDto()));
		personnelAdministratif.setRoles(RoleHelper.dtoToModels(personnelAdministratifDto.getRoles()));
		return personnelAdministratif;
	}

	public static PersonnelAdministratifDto modelToDto(PersonnelAdministratif personnelAdministratif) {
		
		if(personnelAdministratif == null)
			return null;
		
		PersonnelAdministratifDto personnelAdministratifDto = new PersonnelAdministratifDto();
		
		personnelAdministratifDto.setPersonnelId(personnelAdministratif.getPersonnelId());
		personnelAdministratifDto.setNom(personnelAdministratif.getNom());
		personnelAdministratifDto.setPrenom(personnelAdministratif.getPrenom());
		personnelAdministratifDto.setCin(personnelAdministratif.getCin());
		personnelAdministratifDto.setAdresse(personnelAdministratif.getAdresse());
		personnelAdministratifDto.setEmail(personnelAdministratif.getEmail());
		personnelAdministratifDto.setTelephoneMobile(personnelAdministratif.getTelephoneMobile());
		personnelAdministratifDto.setDepartementDto(DepartementHelper.modelToDto(personnelAdministratif
				.getDepartement()));
		personnelAdministratifDto.setLogin(personnelAdministratif.getLogin());
		personnelAdministratifDto.setPassword(personnelAdministratif.getPassword());
		personnelAdministratifDto.setRoles(RoleHelper.modelsToDto(personnelAdministratif.getRoles()));
		personnelAdministratifDto.setFonction(personnelAdministratif.getFonction());
		personnelAdministratifDto.setTelFixe(personnelAdministratif.getTelFixe());
		return personnelAdministratifDto;
	}

	public static Collection<PersonnelAdministratifDto> modelsToDto(
			Collection<PersonnelAdministratif> personnels) {

		Collection<PersonnelAdministratifDto> personnelsDto = new ArrayList<PersonnelAdministratifDto>();

		for (PersonnelAdministratif personnel : personnels) {
			personnelsDto.add(modelToDto(personnel));
		}
		return personnelsDto;
	}

	public static Collection<PersonnelAdministratif> dtoToModels(
			Collection<PersonnelAdministratifDto> personnlesDto) {
		Collection<PersonnelAdministratif> personnels = new ArrayList<PersonnelAdministratif>();

		for (PersonnelAdministratifDto personnelDto : personnlesDto) {
			personnels.add(dtoToModel(personnelDto));
		}
		return personnels;
	}
}
