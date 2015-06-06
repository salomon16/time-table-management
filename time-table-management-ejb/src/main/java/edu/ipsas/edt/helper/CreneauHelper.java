package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.CreneauDto;
import edu.ipsas.edt.model.Creneau;

public class CreneauHelper {

	public static Creneau dtoToModel(CreneauDto creneauDto) {
		if (creneauDto == null)
			return null;

		Creneau creneau = new Creneau();
		creneau.setCreneauID(creneauDto.getCreneauID());
		creneau.setOrdre(creneauDto.getOrdre());
		creneau.setLibelle(creneauDto.getLibelle());
		creneau.setDisponibilites(DisponibiliteHelper.dtoToModels(creneauDto
				.getDisponibilites()));
		return creneau;
	}

	public static CreneauDto modelToDto(Creneau creneau) {
		if (creneau == null)
			return null;

		CreneauDto creneauDto = new CreneauDto();
		creneauDto.setCreneauID(creneau.getCreneauID());
		creneauDto.setOrdre(creneau.getOrdre());
		creneauDto.setLibelle(creneau.getLibelle());
		creneauDto.setDisponibilites(DisponibiliteHelper.modelsToDto(creneau
				.getDisponibilites()));
		return creneauDto;
	}

	public static Collection<CreneauDto> modelsToDto(
			Collection<Creneau> creneaux) {
		Collection<CreneauDto> creneauxDto = new ArrayList<CreneauDto>();

		for (Creneau creneau : creneaux) {
			creneauxDto.add(modelToDto(creneau));
		}
		return creneauxDto;
	}
}
