package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.SalleDto;
import edu.ipsas.edt.model.Salle;

public class SalleHelper {

	public static Salle dtoToModel(SalleDto salleDto) {
		if (salleDto == null)
			return null;

		Salle salle = new Salle();
		salle.setSalleId(salleDto.getSalleId());
		salle.setNumero(salleDto.getNumero());
		salle.setCapacite(salleDto.getCapacite());
		salle.setTypeSalle(salleDto.getTypeSalle());
		salle.setDepartement(DepartementHelper.dtoToModel(salleDto.getDepartementDto()));
		salle.setRessources(RessourceHelper.dtoToModels(salleDto
				.getRessourcesDto()));
		return salle;
	}

	public static SalleDto modelToDto(Salle salle) {

		if (salle == null)
			return null;

		SalleDto salleDto = new SalleDto();

		salleDto.setSalleId(salle.getSalleId());
		salleDto.setNumero(salle.getNumero());
		salleDto.setCapacite(salle.getCapacite());
		salleDto.setTypeSalle(salle.getTypeSalle());
		salleDto.setDepartementDto(DepartementHelper.modelToDto(salle.getDepartement()));
		salleDto.setRessourcesDto(RessourceHelper.modelsToDto(salle
				.getRessources()));

		return salleDto;
	}

	public static Collection<SalleDto> modelsToDto(Collection<Salle> salles) {
		Collection<SalleDto> sallesDto = new ArrayList<SalleDto>();

		for (Salle salle : salles) {
			sallesDto.add(modelToDto(salle));
		}
		return sallesDto;
	}

	public static Collection<Salle> dtoToModels(Collection<SalleDto> sallesDto) {
		Collection<Salle> salles = new ArrayList<Salle>();

		for (SalleDto salleDto : sallesDto) {
			salles.add(dtoToModel(salleDto));
		}
		return salles;
	}
}
