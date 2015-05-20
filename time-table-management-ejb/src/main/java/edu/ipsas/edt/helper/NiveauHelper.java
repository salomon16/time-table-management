package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.NiveauDto;
import edu.ipsas.edt.model.Niveau;

public class NiveauHelper {

	public static Niveau dtoToModel(NiveauDto niveauDto) {
		
		if(niveauDto == null){
			return null;
		}
		Niveau niveau = new Niveau();
		
		niveau.setNiveauId(niveauDto.getNiveauId());
		niveau.setAbbreviation(niveauDto.getAbbreviation());
		niveau.setGroupes(GroupeHelper.dtoToModels(niveauDto.getGroupesDto()));
		niveau.setParcours(ParcoursHelper.dtoToModel(niveauDto.getParcoursDto()));
		niveau.setNom(niveauDto.getNom());
		
		return niveau;
	}

	public static NiveauDto modelToDto(Niveau niveau) {
		if(niveau == null){
			return null;
		}
		NiveauDto niveauDto = new NiveauDto();
		
		niveauDto.setNiveauId(niveau.getNiveauId());
		niveauDto.setAbbreviation(niveau.getAbbreviation());
		niveauDto.setGroupesDto(GroupeHelper.modelsToDto(niveau.getGroupes()));
		niveauDto.setParcoursDto(ParcoursHelper.modelToDto(niveau.getParcours()));
		niveauDto.setNom(niveau.getNom());
		
		return niveauDto;
	}

	public static Collection<NiveauDto> modelsToDto(Collection<Niveau> niveaux) {
		
		Collection<NiveauDto> niveauxDto = new ArrayList<NiveauDto>();
		
		for(Niveau niveau : niveaux){
			niveauxDto.add(modelToDto(niveau));
		}
		return niveauxDto;
	}

	public static Collection<Niveau> dtoToModels(Collection<NiveauDto> niveauxDto) {
	
		Collection<Niveau> niveaux = new ArrayList<Niveau>();
		
		for(NiveauDto niveauDto : niveauxDto){
			niveaux.add(dtoToModel(niveauDto));
		}
		return niveaux;
	}



	
}
