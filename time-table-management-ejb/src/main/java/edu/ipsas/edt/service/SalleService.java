package edu.ipsas.edt.service;

import java.util.Collection;

import javax.ejb.Remote;

import edu.ipsas.edt.dto.EtablissementDto;
import edu.ipsas.edt.dto.RessourceDto;
import edu.ipsas.edt.dto.SalleDto;
import edu.ipsas.edt.dto.TypeSalleDto;

@Remote
public interface SalleService {
	public void updateEtablissement(EtablissementDto etablissementDto);

	public String addEtablissement(EtablissementDto etablissementDto);

	public long addSalle(SalleDto salleDto);

	public void updateSalle(SalleDto salleDto);

	public void deleteSalle(SalleDto salleDto);

	public Collection<SalleDto> getAllSalle();

	public long addRessource(RessourceDto ressourceDto);

	public void updateRessource(RessourceDto ressourceDto);

	public void deleteRessource(RessourceDto ressourceDto);

	public Collection<RessourceDto> getAllRessource();

	public long addTypeSalle(TypeSalleDto typeSalleDto);

	public void updateTypeSalle(TypeSalleDto typeSalleDto);

	public void deleteTypeSalle(TypeSalleDto typeSalleDto);

	public Collection<TypeSalleDto> getAllTypeSalle();
	
	public TypeSalleDto getTypeSalleByName(String name);

	public Collection<SalleDto> getAllSalleByDepartement(String departementName);


}
