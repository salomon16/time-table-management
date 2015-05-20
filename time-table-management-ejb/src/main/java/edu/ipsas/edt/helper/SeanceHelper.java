package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.SeanceDto;
import edu.ipsas.edt.model.Seance;

public class SeanceHelper {

	public static Seance dtoToModel(SeanceDto seanceDto){
		if(seanceDto == null){
			return null;
		}
		
		Seance seance = new Seance();
		seance.setSeanceId(seanceDto.getSeanceId());
		seance.setJour(seanceDto.getJour());
		seance.setMatiere(MatiereHelper.dtoToModel(seanceDto.getMatiereDto()));
		seance.setEnseignant(EnseignantHelper.dtoToModel(seanceDto.getEnseignantDto()));
		seance.setCreneau(CreneauHelper.dtoToModel(seanceDto.getCreneauDto()));
		seance.setSalle(SalleHelper.dtoToModel(seanceDto.getSalleDto()));
		seance.setEmploi(EmploiHelper.dtoToModel(seanceDto.getEmploiDto()));
		
		return seance;
	}
	
	public static SeanceDto modelToDto(Seance seance){
		if(seance == null){
			return null;
		}
		
		SeanceDto seanceDto = new SeanceDto();
		seanceDto.setSeanceId(seance.getSeanceId());
		seanceDto.setJour(seance.getJour());
		seanceDto.setMatiereDto(MatiereHelper.modelToDto(seance.getMatiere()));
		seanceDto.setEnseignantDto(EnseignantHelper.modelToDto(seance.getEnseignant()));
		seanceDto.setCreneauDto(CreneauHelper.modelToDto(seance.getCreneau()));
		seanceDto.setSalleDto(SalleHelper.modelToDto(seance.getSalle()));
		seanceDto.setEmploiDto(EmploiHelper.modelToDto(seance.getEmploi()));
		
		return seanceDto;
	}
	
	public static Collection<Seance> dtoToModels(Collection<SeanceDto> seancesDto) {
		
		Collection<Seance> seances = new ArrayList<Seance>();
		for(SeanceDto seanceDto : seancesDto){
			seances.add(dtoToModel(seanceDto));
		}
		return seances;
	}

	public static Collection<SeanceDto> modelsToDto(Collection<Seance> seances) {
		
		Collection<SeanceDto> seancesDto = new ArrayList<SeanceDto>();
		
		for(Seance seance : seances){
			seancesDto.add(modelToDto(seance));
		}
		return seancesDto;
	}

}
