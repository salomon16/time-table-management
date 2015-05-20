package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.EmploiDto;
import edu.ipsas.edt.model.Emploi;

public class EmploiHelper {

	public static Emploi dtoToModel(EmploiDto emploiDto){
		
		if(emploiDto == null){
			return null;
		}
		
		Emploi emploi = new Emploi();
		emploi.setEmploiId(emploiDto.getEmploiId());
		emploi.setDateDebut(emploiDto.getDateDebut());
		emploi.setDateFin(emploiDto.getDateFin());
		emploi.setGroupe(GroupeHelper.dtoToModel(emploiDto.getGroupeDto()));
		emploi.setAnneeAcademique(AnneeHelper.dtoToModel(emploiDto.getAnneeAcademiqueDto()));
		emploi.setHoraireDebut(emploiDto.getHoraireDebut());
		emploi.setHoraireFin(emploiDto.getHoraireFin());
//		emploi.setSemestre(SemestreHelper.dtoToModel(emploiDto.getSemestreDto()));
		emploi.setSeance(SeanceHelper.dtoToModels(emploiDto.getSeanceDto()));
		return emploi;
	}
	
	public static EmploiDto modelToDto(Emploi emploi){
		if(emploi == null){
			return null;
		}
		
		EmploiDto emploiDto = new EmploiDto();
		emploiDto.setEmploiId(emploi.getEmploiId());
		emploiDto.setDateDebut(emploi.getDateDebut());
		emploiDto.setDateFin(emploi.getDateFin());
		emploiDto.setGroupeDto(GroupeHelper.modelToDto(emploi.getGroupe()));
		emploiDto.setSeanceDto(SeanceHelper.modelsToDto(emploi.getSeance()));
		emploiDto.setHoraireDebut(emploi.getHoraireDebut());
		emploiDto.setHoraireFin(emploi.getHoraireFin());
//		emploiDto.setSemestreDto(SemestreHelper.modelToDto(emploi.getSemestre()));
		emploiDto.setAnneeAcademiqueDto(AnneeHelper.modelToDto(emploi.getAnneeAcademique()));
		
		return emploiDto;
	}

	public static Collection<Emploi> dtoToModels(Collection<EmploiDto> emploisDto) {
		
		Collection<Emploi> emplois = new ArrayList<Emploi>();
		for(EmploiDto emploiDto : emploisDto){
			emplois.add(dtoToModel(emploiDto));
		}
		return emplois;
	}

	public static Collection<EmploiDto> modelsToDto(Collection<Emploi> emplois) {
		Collection<EmploiDto> emploisDto = new ArrayList<EmploiDto>();
		
		for(Emploi emploi : emplois){
			emploisDto.add(modelToDto(emploi));
		}
		return emploisDto;
	}
	
}
