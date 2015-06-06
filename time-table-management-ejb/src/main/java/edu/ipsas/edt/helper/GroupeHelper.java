package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.GroupeDto;
import edu.ipsas.edt.model.Groupe;

public class GroupeHelper {

	public static Groupe dtoToModel(GroupeDto groupeDto) {
		
		if(groupeDto == null){
			return null;
		}
		
		Groupe groupe = new Groupe();
		groupe.setGroupeId(groupeDto.getGroupeId());
		groupe.setNom(groupeDto.getNom());
		groupe.setAbbreviation(groupeDto.getAbbreviation());
		groupe.setNiveau(NiveauHelper.dtoToModel(groupeDto.getNiveauDto()));
		groupe.setEmploi(EmploiHelper.dtoToModels(groupeDto.getEmploiDto()));
		
		return groupe;
	}

	public static GroupeDto modelToDto(Groupe groupe) {
		if(groupe == null){
			return null;
		}
		
		GroupeDto groupeDto = new GroupeDto();
		groupeDto.setGroupeId(groupe.getGroupeId());
		groupeDto.setNom(groupe.getNom());
		groupeDto.setAbbreviation(groupe.getAbbreviation());
		groupeDto.setNiveauDto(NiveauHelper.modelToDto(groupe.getNiveau()));
		groupeDto.setEmploiDto(EmploiHelper.modelsToDto(groupe.getEmploi()));
		
		return groupeDto;
	}

	public static Collection<Groupe> dtoToModels(Collection<GroupeDto> groupesDto) {
		Collection<Groupe> groupes = new ArrayList<Groupe>();
		
		for(GroupeDto groupeDto : groupesDto){
			groupesDto.add(groupeDto);
		}
		return groupes;
	}

	public static Collection<GroupeDto> modelsToDto(Collection<Groupe> groupes) {
		Collection<GroupeDto> groupesDto = new ArrayList<GroupeDto>();
		
		for(Groupe groupe : groupes){
			groupesDto.add(modelToDto(groupe));
		}
		return groupesDto;
	}
	

}
