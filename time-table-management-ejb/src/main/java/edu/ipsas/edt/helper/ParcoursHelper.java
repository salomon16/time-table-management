package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.model.Parcours;

public class ParcoursHelper {

	public static Parcours dtoToModel(ParcoursDto parcoursDto) {
		if(parcoursDto == null)
			return null;
		
		Parcours parcours = new Parcours();
		parcours.setParcoursID(parcoursDto.getParcoursId());
		parcours.setNom(parcoursDto.getNom());
		parcours.setCursus(CursusHelper.dtoToModel(parcoursDto.getCursusDto()));
		return parcours;
	}

	public static ParcoursDto modelToDto(Parcours parcours) {
		if(parcours == null)
			return null;
		
		ParcoursDto parcoursDto = new ParcoursDto();
		parcoursDto.setParcoursId(parcours.getParcoursID());
		parcoursDto.setNom(parcours.getNom());
		parcoursDto.setCursusDto(CursusHelper.modelToDto(parcours
				.getCursus()));
		return parcoursDto;
	}

	public static Collection<Parcours> dtoToModels(
			Collection<ParcoursDto> parcoursDto) {
		Collection<Parcours> parcours = new ArrayList<Parcours>();
		for (ParcoursDto parcourDto : parcoursDto) {
			parcours.add(dtoToModel(parcourDto));
		}
		return parcours;
	}

	public static Collection<ParcoursDto> modelsToDto(
			Collection<Parcours> parcours) {
		Collection<ParcoursDto> parcoursDto = new ArrayList<ParcoursDto>();
		for (Parcours parcour : parcours) {
			parcoursDto.add(modelToDto(parcour));
		}
		return parcoursDto;
	}
}
