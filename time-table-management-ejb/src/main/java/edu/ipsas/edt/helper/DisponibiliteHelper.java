package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.DisponibiliteDto;
import edu.ipsas.edt.model.Disponibilite;

public class DisponibiliteHelper {

	public static Disponibilite dtoToModel(DisponibiliteDto disponibiliteDto) {
		if (disponibiliteDto == null)
			return null;

		Disponibilite disponibilite = new Disponibilite();
		disponibilite.setDisponibiliteID(disponibiliteDto.getDisponibiliteID());
		disponibilite.setJour(disponibiliteDto.getJour());
		disponibilite.setCreneau(CreneauHelper.dtoToModel(disponibiliteDto
				.getCreneauDto()));
		disponibilite.setEnseignant(EnseignantHelper
				.dtoToModel(disponibiliteDto.getEnseignantDto()));
		return disponibilite;
	}

	public static DisponibiliteDto modelToDto(Disponibilite disponibilite) {

		if (disponibilite == null)
			return null;

		DisponibiliteDto disponibiliteDto = new DisponibiliteDto();
		disponibiliteDto.setDisponibiliteID(disponibilite.getDisponibiliteID());
		disponibiliteDto.setCreneauDto(CreneauHelper.modelToDto(disponibilite
				.getCreneau()));
		disponibiliteDto.setJour(disponibilite.getJour());
		disponibiliteDto.setEnseignantDto(EnseignantHelper
				.modelToDto(disponibilite.getEnseignant()));
		return disponibiliteDto;
	}

	public static Collection<Disponibilite> dtoToModels(
			Collection<DisponibiliteDto> disponibilitesDto) {

		Collection<Disponibilite> disponibilites = new ArrayList<Disponibilite>();

		for (DisponibiliteDto disponibiliteDto : disponibilitesDto) {
			disponibilites.add(dtoToModel(disponibiliteDto));
		}
		return disponibilites;
	}

	public static Collection<DisponibiliteDto> modelsToDto(
			Collection<Disponibilite> disponibilites) {
		Collection<DisponibiliteDto> disponibilitesDto = new ArrayList<DisponibiliteDto>();

		for (Disponibilite disponibilite : disponibilites) {
			disponibilitesDto.add(modelToDto(disponibilite));
		}
		return disponibilitesDto;
	}

}
