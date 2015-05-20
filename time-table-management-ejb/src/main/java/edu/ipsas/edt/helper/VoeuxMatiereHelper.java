package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.VoeuxMatiereDto;
import edu.ipsas.edt.model.VoeuxMatiere;

public class VoeuxMatiereHelper {

	public static VoeuxMatiere dtoToModel(VoeuxMatiereDto voeuxDto) {
		if(voeuxDto == null){
			return null;
		}
		VoeuxMatiere voeuxMatiere = new VoeuxMatiere();
		voeuxMatiere.setVoeuxMatiereId(voeuxDto.getVoeuxMatiereId());
		voeuxMatiere.setAffecte(voeuxDto.isAffecte());
		voeuxMatiere.setEnseignant(EnseignantHelper.dtoToModel(voeuxDto.getEnseignantDto()));
		voeuxMatiere.setMatiere(MatiereHelper.dtoToModel(voeuxDto.getMatiereDto()));
		return null;
	}

	public static Collection<VoeuxMatiereDto> modelsToDto(
			Collection<VoeuxMatiere> voeuxMatieres) {
		Collection<VoeuxMatiereDto> voeuxMatieresDto = new ArrayList<VoeuxMatiereDto>();
		for(VoeuxMatiere voeuxMatiere : voeuxMatieres){
			voeuxMatieresDto.add(modelToDto(voeuxMatiere));
		}
		return voeuxMatieresDto;
	}

	private static VoeuxMatiereDto modelToDto(VoeuxMatiere voeuxMatiere) {
		if(voeuxMatiere == null){
			return null;
		}
		VoeuxMatiereDto voeuxMatiereDto = new VoeuxMatiereDto();
		voeuxMatiereDto.setVoeuxMatiereId(voeuxMatiere.getVoeuxMatiereId());
		voeuxMatiereDto.setVoeuxMatiereId(voeuxMatiere.getVoeuxMatiereId());
		voeuxMatiereDto.setEnseignantDto(EnseignantHelper.modelToDto(voeuxMatiere.getEnseignant()));
		voeuxMatiereDto.setMatiereDto(MatiereHelper.modelToDto(voeuxMatiere.getMatiere()));
		return null;
	}

}
