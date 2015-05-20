package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.UniteDto;
import edu.ipsas.edt.model.Unite;

public class UniteHelper {

	public static Unite dtoToModel(UniteDto uniteDto) {
		if(uniteDto == null){
			return null;
		}
		
		Unite unite = new Unite();
		unite.setUniteId(uniteDto.getUniteId());
		unite.setNom(uniteDto.getNom());
		unite.setMatieres(MatiereHelper.dtoToModels(uniteDto.getMatieresDto()));
		return unite;
	}

	public static Collection<UniteDto> modelsToDto(Collection<Unite> unites) {
		
		Collection<UniteDto> unitesDto = new ArrayList<UniteDto>();
		for(Unite unite : unites){
			unitesDto.add(modelToDto(unite));
		}
		return unitesDto;
	}

	public static UniteDto modelToDto(Unite unite) {
		
		if(unite == null){
			return null;
		}
		
		UniteDto uniteDto = new UniteDto();
		uniteDto.setUniteId(unite.getUniteId());
		uniteDto.setNom(unite.getNom());
		uniteDto.setMatieresDto(MatiereHelper.modelsToDto(unite.getMatieres()));
		return uniteDto;
	}

}
