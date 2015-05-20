package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.model.Matiere;

public class MatiereHelper {

	public static Matiere dtoToModel(MatiereDto matiereDto) {
		
		if(matiereDto == null){
			return null;
		}
		
		Matiere matiere = new Matiere();
		matiere.setMatiereId(matiereDto.getMatiereId());
		matiere.setNom(matiereDto.getNom());
		matiere.setDescription(matiereDto.getDescription());
		matiere.setUnite(UniteHelper.dtoToModel(matiereDto.getUniteDto()));
		matiere.setVolumeC(matiereDto.getVolumeC());
		matiere.setVolumeTd(matiere.getVolumeTd());
		matiere.setVolumeTp(matiereDto.getVolumeTp());
		matiere.setCredit(matiereDto.getCredit());
		matiere.setCoefficient(matiereDto.getCoefficient());
		matiere.setPlansEtude(PlanEtudeHelper.dtoToModels(matiereDto.getPlansEtudeDto()));
		return matiere;
	}

	public static MatiereDto modelToDto(Matiere matiere) {
		
		if(matiere == null){
			return null;
		}
		
		MatiereDto matiereDto = new MatiereDto();
		matiereDto.setMatiereId(matiere.getMatiereId());
		matiereDto.setNom(matiere.getNom());
		matiereDto.setDescription(matiere.getDescription());
		matiereDto.setType(matiere.getType());
		matiereDto.setVolumeC(matiere.getVolumeC());
		matiereDto.setVolumeTd(matiere.getVolumeTd());
		matiereDto.setVolumeTp(matiere.getVolumeTp());
		matiereDto.setCoefficient(matiere.getCoefficient());
		matiereDto.setCredit(matiere.getCredit());
		matiereDto.setPlansEtudeDto(PlanEtudeHelper.modelsToDto(matiere.getPlansEtude()));
		matiereDto.setUniteDto(UniteHelper.modelToDto(matiere.getUnite()));
		return matiereDto;
	}

	public static Collection<MatiereDto> modelsToDto(Collection<Matiere> matieres) {
		Collection<MatiereDto> matieresDto = new ArrayList<MatiereDto>();
		for (Matiere matiere : matieres) {
			matieresDto.add(modelToDto(matiere));
		}
		return matieresDto;
	}

	public static Collection<Matiere> dtoToModels(
			Collection<MatiereDto> matieresDto) {
		List<Matiere> matieres = new ArrayList<Matiere>();
		
		for(MatiereDto matiereDto : matieresDto){
			matieres.add(dtoToModel(matiereDto));
		}
		return matieres;
	}
}
