package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.SemestreDto;
import edu.ipsas.edt.model.Semestre;

public class SemestreHelper {

	public static SemestreDto modelToDto(Semestre semestre) {
		if(semestre == null){
				return null;
		}
		
		SemestreDto semestreDto = new SemestreDto();
		semestreDto.setSemestreId(semestre.getSemestreId());
		semestreDto.setNumero(semestre.getNumero());
		semestreDto.setPlansEtudeDto(PlanEtudeHelper.modelsToDto(semestre.getPlansEtude()));
		
		return semestreDto;
	}

	public static Semestre dtoToModel(SemestreDto semestreDto) {
		if(semestreDto == null){
			return null;
		}
	
	Semestre semestre = new Semestre();
	semestre.setSemestreId(semestreDto.getSemestreId());
	semestre.setNumero(semestreDto.getNumero());
	semestre.setPlansEtude(PlanEtudeHelper.dtoToModels(semestreDto.getPlansEtudeDto()));
	
	return semestre;
}

	public static Collection<SemestreDto> modelsToDto(
			Collection<Semestre> semestres) {
		Collection<SemestreDto> semestresDto = new ArrayList<SemestreDto>();
		
		for(Semestre semestre : semestres){
			semestresDto.add(modelToDto(semestre));
		}
		return semestresDto;
	}

}
