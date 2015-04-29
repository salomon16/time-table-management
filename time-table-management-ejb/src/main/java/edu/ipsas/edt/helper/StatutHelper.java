package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.StatutDto;
import edu.ipsas.edt.model.Statut;

public class StatutHelper {

	public static Statut dtoToModel(StatutDto statutDto) {
		if (statutDto == null)
			return null;
		Statut statut = new Statut();
		statut.setStatutID(statutDto.getStatutID());
		statut.setNom(statutDto.getNom());
		statut.setEnseignants(EnseignantHelper.dtoToModels(statutDto
				.getEnseignants()));
		return statut;
	}

	public static StatutDto modelToDto(Statut statut) {
		if (statut == null)
			return null;
		StatutDto statutDto = new StatutDto();
		statutDto.setStatutID(statut.getStatutID());
		statutDto.setNom(statut.getNom());
		statutDto.setEnseignants(EnseignantHelper.modelsToDto(statut
				.getEnseignants()));
		return statutDto;
	}

	public static Collection<StatutDto> modelsToDto(Collection<Statut> statuts) {

		Collection<StatutDto> statutsDto = new ArrayList<StatutDto>();

		for (Statut statut : statuts) {
			statutsDto.add(modelToDto(statut));
		}
		return statutsDto;
	}

	public static Collection<Statut> dtoToModels(
			Collection<StatutDto> statutsDto) {
		Collection<Statut> statuts = new ArrayList<Statut>();

		for (StatutDto statutDto : statutsDto) {
			statuts.add(dtoToModel(statutDto));
		}
		return statuts;
	}

}
