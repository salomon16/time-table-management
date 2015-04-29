package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.CursusDto;
import edu.ipsas.edt.model.Cursus;

public class CursusHelper {

	public static Collection<CursusDto> modelsToDto(
			Collection<Cursus> cursus) {

		Collection<CursusDto> cursusDto = new ArrayList<CursusDto>();
		for (Cursus specialite : cursus) {
			cursusDto.add(modelToDto(specialite));
		}
		return cursusDto;
	}

	public static Collection<Cursus> dtoToModels(
			Collection<CursusDto> cursusDto) {
		Collection<Cursus> listeCursus = new ArrayList<Cursus>();
		for (CursusDto cursus : cursusDto) {
			listeCursus.add(dtoToModel(cursus));
		}
		return listeCursus;
	}

	public static Cursus dtoToModel(CursusDto cursusDto) {

		if (cursusDto == null)
			return null;

		Cursus cursus = new Cursus();
		cursus.setCursusId(cursusDto.getCursusId());
		cursus.setNom(cursusDto.getNom());
		cursus.setDepartement(DepartementHelper.dtoToModel(cursusDto
				.getDepartementDto()));
		cursus.setParcours(ParcoursHelper.dtoToModels(cursusDto
				.getParcours()));

		return cursus;
	}

	public static CursusDto modelToDto(Cursus cursus) {
		if (cursus == null)
			return null;

		CursusDto cursusDto = new CursusDto();
		cursusDto.setCursusId(cursus.getCursusId());
		cursusDto.setNom(cursus.getNom());
		cursusDto.setDepartementDto(DepartementHelper.modelToDto(cursus
				.getDepartement()));
		cursusDto.setParcours(ParcoursHelper.modelsToDto(cursus.getParcours()));
		return cursusDto;
	}

}
