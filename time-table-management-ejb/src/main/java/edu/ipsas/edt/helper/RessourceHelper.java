package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.RessourceDto;
import edu.ipsas.edt.model.Ressource;

public class RessourceHelper {

	public static Ressource dtoToModel(RessourceDto ressourceDto) {
		if (ressourceDto == null)
			return null;

		Ressource ressource = new Ressource();
		ressource.setRessourceID(ressource.getRessourceID());
		ressource.setNom(ressourceDto.getNom());
		ressource.setSalle(SalleHelper.dtoToModel(ressourceDto.getSalleDto()));

		return ressource;
	}

	public static RessourceDto modelToDto(Ressource ressource) {

		if (ressource == null)
			return null;

		RessourceDto ressourceDto = new RessourceDto();
		ressourceDto.setRessourceID(ressource.getRessourceID());
		ressourceDto.setNom(ressource.getNom());
		ressourceDto.setSalleDto(SalleHelper.modelToDto(ressource.getSalle()));
		return ressourceDto;
	}

	public static Collection<Ressource> dtoToModels(
			Collection<RessourceDto> ressourcesDto) {
		Collection<Ressource> ressources = new ArrayList<Ressource>();

		for (RessourceDto ressourceDto : ressourcesDto) {
			ressources.add(dtoToModel(ressourceDto));
		}
		return ressources;
	}

	public static Collection<RessourceDto> modelsToDto(
			Collection<Ressource> ressources) {
		Collection<RessourceDto> ressourcesDto = new ArrayList<RessourceDto>();

		for (Ressource ressource : ressources) {
			ressourcesDto.add(modelToDto(ressource));
		}
		return ressourcesDto;
	}

}
