package edu.ipsas.edt.helper;

import edu.ipsas.edt.dto.EtablissementDto;
import edu.ipsas.edt.model.Etablissement;

public class EtablissementHelper {

	public static Etablissement dtoToModel(EtablissementDto etablissementDto){
		if(etablissementDto == null)
			return null;
		
		Etablissement etablissement = new Etablissement();
		etablissement.setEtablissementID(etablissementDto.getEtablissementID());
		etablissement.setNom(etablissementDto.getNom());
		etablissement.setAbbreviation(etablissementDto.getAbbreviation());
		etablissement.setAdresse(etablissementDto.getAdresse());
		etablissement.setDepartements(DepartementHelper.dtoToModels(etablissementDto.getDepartements()));
		return etablissement;
	}
	
	public static EtablissementDto modelToDto(Etablissement etablissement){
		
		if(etablissement == null)
			return null;
		
		EtablissementDto etablissementDto = new EtablissementDto();
		etablissementDto.setEtablissementID(etablissement.getEtablissementID());
		etablissementDto.setNom(etablissement.getNom());
		etablissementDto.setAbbreviation(etablissement.getAbbreviation());
		etablissementDto.setAdresse(etablissement.getAdresse());
		etablissementDto.setDepartements(DepartementHelper.modelsToDto(etablissement.getDepartements()));
		etablissementDto.setSalles(SalleHelper.modelsToDto(etablissement.getSalles()));
		return etablissementDto;
	}
}
