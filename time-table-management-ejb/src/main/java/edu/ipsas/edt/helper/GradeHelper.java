package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.GradeDto;
import edu.ipsas.edt.model.Grade;

public class GradeHelper {

	public static Grade dtoToModel(GradeDto gradeDto) {
		if (gradeDto == null)
			return null;

		Grade grade = new Grade();
		grade.setGradeID(gradeDto.getGradeID());
		grade.setNom(gradeDto.getNom());
		grade.setEnseignants(EnseignantHelper.dtoToModels(gradeDto
				.getEnseignants()));
		return grade;
	}

	public static GradeDto modelToDto(Grade grade) {
		if(grade == null)
			return null;
		
		GradeDto gradeDto = new GradeDto();
		gradeDto.setGradeID(grade.getGradeID());
		gradeDto.setNom(grade.getNom());
		gradeDto.setEnseignants(EnseignantHelper.modelsToDto(grade
				.getEnseignants()));
		return gradeDto;
	}

	public static Collection<Grade> dtoToModels(Collection<GradeDto> gradesDto) {

		Collection<Grade> grades = new ArrayList<Grade>();

		for (GradeDto gradeDto : gradesDto) {
			grades.add(dtoToModel(gradeDto));
		}
		return grades;
	}

	public static Collection<GradeDto> modelsToDto(Collection<Grade> grades) {
		Collection<GradeDto> gradesDto = new ArrayList<GradeDto>();
		for (Grade grade : grades) {
			gradesDto.add(modelToDto(grade));
		}
		return gradesDto;
	}
}
