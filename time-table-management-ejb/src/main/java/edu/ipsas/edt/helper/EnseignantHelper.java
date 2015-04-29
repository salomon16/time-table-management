package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.EnseignantDto;
import edu.ipsas.edt.model.Enseignant;

public class EnseignantHelper {

	public static Enseignant dtoToModel(EnseignantDto enseignantDto) {
		
		if(enseignantDto == null)
			return null;
		
		Enseignant enseignant = new Enseignant();
		enseignant.setEnseignantID(enseignantDto.getEnseignantID());
		enseignant.setNom(enseignantDto.getNom());
		enseignant.setPrenom(enseignantDto.getPrenom());
		enseignant.setCin(enseignantDto.getCin());
		enseignant.setAdresse(enseignantDto.getAdresse());
		enseignant.setEmail(enseignantDto.getEmail());
		enseignant.setTelephoneMobile(enseignantDto.getTelephoneMobile());
		enseignant.setSpecialite(enseignantDto.getSpecialite());
		enseignant.setStatut(StatutHelper.dtoToModel(enseignantDto
				.getStatutDto()));
		enseignant
				.setGrade(GradeHelper.dtoToModel(enseignantDto.getGradeDto()));
		enseignant.setDepartements(DepartementHelper.dtoToModels(enseignantDto
				.getDepartements()));
		enseignant.setDisponibilites(DisponibiliteHelper
				.dtoToModels(enseignantDto.getDisponibilites()));

		return enseignant;
	}

	public static EnseignantDto modelToDto(Enseignant enseignant) {
		
		if(enseignant == null)
			return null;
		
		EnseignantDto enseignantDto = new EnseignantDto();
		enseignantDto.setEnseignantID(enseignant.getEnseignantID());
		enseignantDto.setNom(enseignant.getNom());
		enseignantDto.setPrenom(enseignant.getPrenom());
		enseignantDto.setCin(enseignant.getCin());
		enseignantDto.setAdresse(enseignant.getAdresse());
		enseignantDto.setEmail(enseignant.getEmail());
		enseignantDto.setTelephoneMobile(enseignant.getTelephoneMobile());
		enseignantDto.setSpecialite(enseignant.getSpecialite());
		enseignantDto.setStatutDto(StatutHelper.modelToDto(enseignant
				.getStatut()));
		enseignantDto
				.setGradeDto(GradeHelper.modelToDto(enseignant.getGrade()));
		enseignantDto.setDepartements(DepartementHelper.modelsToDto(enseignant
				.getDepartements()));
		enseignantDto.setDisponibilites(DisponibiliteHelper
				.modelsToDto(enseignant.getDisponibilites()));
		enseignantDto.setLogin(enseignant.getLogin());
		enseignantDto.setPassword(enseignant.getPassword());
		return enseignantDto;
	}

	public static Collection<EnseignantDto> modelsToDto(
			Collection<Enseignant> enseignants) {

		Collection<EnseignantDto> enseignantsDto = new ArrayList<EnseignantDto>();

		for (Enseignant enseignant : enseignants) {
			enseignantsDto.add(modelToDto(enseignant));
		}
		return enseignantsDto;
	}

	public static Collection<Enseignant> dtoToModels(
			Collection<EnseignantDto> enseignantsDto) {
		Collection<Enseignant> enseignants = new ArrayList<Enseignant>();

		for (EnseignantDto enseignantDto : enseignantsDto) {
			enseignants.add(dtoToModel(enseignantDto));
		}
		return enseignants;
	}

}
