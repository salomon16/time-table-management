package edu.ipsas.edt.helper;

import edu.ipsas.edt.dto.AnneeAcademiqueDto;
import edu.ipsas.edt.model.AnneeAcademique;

public class AnneeHelper {

	public static AnneeAcademique dtoToModel(AnneeAcademiqueDto anneeDto) {
		
		if(anneeDto == null){
			return null;
		}
		
		AnneeAcademique annee = new AnneeAcademique();
		annee.setAnneeId(anneeDto.getAnneeId());
		annee.setAnneeCourante(anneeDto.getAnneeCourante());
		annee.setEmploi(EmploiHelper.dtoToModels(anneeDto.getEmploisDto()));
		
		return annee;
	}

	public static AnneeAcademiqueDto modelToDto(AnneeAcademique annee) {
		
		if(annee == null){
			return null;
		}
		AnneeAcademiqueDto anneeDto = new AnneeAcademiqueDto();
		anneeDto.setAnneeId(annee.getAnneeId());
		anneeDto.setAnneeCourante(annee.getAnneeCourante());
		anneeDto.setEmploi(EmploiHelper.modelsToDto(annee.getEmploi()));
		return null;
	}

}
