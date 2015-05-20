package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.PlanEtudeDto;
import edu.ipsas.edt.model.PlanEtude;

public class PlanEtudeHelper {

	public static PlanEtude dtoToModel(PlanEtudeDto planEtudeDto){
		if(planEtudeDto == null){
			return null;
		}
		
		PlanEtude planEtude = new PlanEtude();
		
		planEtude.setPlanEtudeId(planEtudeDto.getPlanEtudeId());
		planEtude.setParcours(ParcoursHelper.dtoToModel(planEtudeDto.getParcoursDto()));
		planEtude.setSemestre(SemestreHelper.dtoToModel(planEtudeDto.getSemestreDto()));
		planEtude.setMatieres(MatiereHelper.dtoToModels(planEtudeDto.getMatieresDto()));
		return planEtude;
	}
	
	public static PlanEtudeDto modelToDto(PlanEtude planEtude){
		
		if(planEtude == null){
			return null;
		}
		
		PlanEtudeDto planEtudeDto = new PlanEtudeDto();
		
		planEtudeDto.setPlanEtudeId(planEtude.getPlanEtudeId());
		planEtudeDto.setParcoursDto(ParcoursHelper.modelToDto(planEtude.getParcours()));
		planEtudeDto.setSemestreDto(SemestreHelper.modelToDto(planEtude.getSemestre()));
		planEtudeDto.setMatieresDto(MatiereHelper.modelsToDto(planEtude.getMatieres()));
		return planEtudeDto;
	}
	
	public static Collection<PlanEtudeDto> modelsToDto(Collection<PlanEtude> plansEtude) {
		
		Collection<PlanEtudeDto> plansEtudeDto = new ArrayList<PlanEtudeDto>();
		for(PlanEtude planEtude : plansEtude){
			
			plansEtudeDto.add(modelToDto(planEtude));
		}
		return plansEtudeDto;
	}

	public static Collection<PlanEtude> dtoToModels(Collection<PlanEtudeDto> plansEtudeDto) {
		
		Collection<PlanEtude> plansEtude = new ArrayList<PlanEtude>();
		for(PlanEtudeDto planEtudeDto : plansEtudeDto){
			
			plansEtude.add(dtoToModel(planEtudeDto));
		}
		return plansEtude;
	}

}
