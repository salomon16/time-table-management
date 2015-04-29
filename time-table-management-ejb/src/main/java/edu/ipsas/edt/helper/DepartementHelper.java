package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.DepartementDto;
import edu.ipsas.edt.model.Departement;

public class DepartementHelper {

	public static Departement dtoToModel(DepartementDto departementDto) {
		if (departementDto == null)
			return null;
		Departement departement = new Departement();
		departement.setDepartementID(departementDto.getDepartementID());
		departement.setNom(departementDto.getNom());
		departement.setEtablissement(EtablissementHelper
				.dtoToModel(departementDto.getEtablissementDto()));
		departement.setEnseignants(EnseignantHelper.dtoToModels(departementDto
				.getEnseignants()));
		departement.setCursus(CursusHelper.dtoToModels(departementDto
				.getSpecialites()));
		departement.setPersonnels(PersonnelAdministratifHelper.dtoToModels(departementDto.getPersonnels()));

		return departement;
	}

	public static DepartementDto modelToDto(Departement departement) {

		if (departement == null)
			return null;

		DepartementDto departementDto = new DepartementDto();

		departementDto.setDepartementID(departement.getDepartementID());
		departementDto.setNom(departement.getNom());
		departementDto.setEtablissementDto(EtablissementHelper
				.modelToDto(departement.getEtablissement()));
		departementDto.setEnseignants(EnseignantHelper.modelsToDto(departement
				.getEnseignants()));
		departementDto.setSpecialites(CursusHelper.modelsToDto(departement
				.getCursus()));
		departementDto.setPersonnels(PersonnelAdministratifHelper.modelsToDto(departement.getPersonnels()));
		return departementDto;

	}

	public static Collection<Departement> dtoToModels(
			Collection<DepartementDto> departementsDto) {
		Collection<Departement> departements = new ArrayList<Departement>();

		for (DepartementDto departementDto : departementsDto) {
			departements.add(dtoToModel(departementDto));
		}
		return departements;
	}

	public static Collection<DepartementDto> modelsToDto(
			Collection<Departement> departements) {
		Collection<DepartementDto> departementsDto = new ArrayList<DepartementDto>();

		for (Departement departement : departements) {
			departementsDto.add(modelToDto(departement));
		}
		return departementsDto;
	}
}
