package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.TypeSalleDto;
import edu.ipsas.edt.model.TypeSalle;

public class TypeSalleHelper {

	public static TypeSalle dtoToModel(TypeSalleDto typeSalleDto) {

		if (typeSalleDto == null)
			return null;

		TypeSalle typeSalle = new TypeSalle();
		typeSalle.setTypeSalleId(typeSalleDto.getTypeSalleId());
		typeSalle.setNom(typeSalleDto.getNom());
		typeSalle.setSalles(SalleHelper.dtoToModels(typeSalleDto.getSalles()));
		return typeSalle;
	}

	public static TypeSalleDto modelToDto(TypeSalle typeSalle) {
		if (typeSalle == null)
			return null;

		TypeSalleDto typeSalleDto = new TypeSalleDto();
		typeSalleDto.setTypeSalleId(typeSalle.getTypeSalleId());
		typeSalleDto.setNom(typeSalle.getNom());
		typeSalleDto.setSalles(SalleHelper.modelsToDto(typeSalle.getSalles()));
		return typeSalleDto;
	}

	public static Collection<TypeSalleDto> modelsToDto(
			Collection<TypeSalle> typeSalles) {
		Collection<TypeSalleDto> typeSallesDto = new ArrayList<TypeSalleDto>();
		for (TypeSalle typeSalle : typeSalles) {
			typeSallesDto.add(modelToDto(typeSalle));
		}
		return typeSallesDto;
	}

	public static Collection<TypeSalle> dtoToModel(
			Collection<TypeSalleDto> typeSallesDto) {
		Collection<TypeSalle> typeSalles = new ArrayList<TypeSalle>();
		for (TypeSalleDto typeSalleDto : typeSallesDto) {
			typeSalles.add(dtoToModel(typeSalleDto));
		}
		return typeSalles;
	}

}
