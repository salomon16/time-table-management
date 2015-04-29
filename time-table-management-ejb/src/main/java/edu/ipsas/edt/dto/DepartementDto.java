package edu.ipsas.edt.dto;

import java.util.ArrayList;
import java.util.Collection;

public class DepartementDto {

	private long departementId;
	private String nom;
	private EtablissementDto etablissementDto;
	private Collection<EnseignantDto> enseignants;
	private Collection<CursusDto> specialites;
	private Collection<PersonnelAdministratifDto> personnels;

	public DepartementDto() {
		super();
		enseignants = new ArrayList<EnseignantDto>();
		specialites = new ArrayList<CursusDto>();
		personnels = new ArrayList<PersonnelAdministratifDto>();
	}

	public DepartementDto(String nom) {
		super();
		this.nom = nom;
		enseignants = new ArrayList<EnseignantDto>();
		specialites = new ArrayList<CursusDto>();
		personnels = new ArrayList<PersonnelAdministratifDto>();
	}

	public DepartementDto(String nom, EtablissementDto etablissementDto) {
		super();
		this.nom = nom;
		this.etablissementDto = etablissementDto;
		enseignants = new ArrayList<EnseignantDto>();
		specialites = new ArrayList<CursusDto>();
		personnels = new ArrayList<PersonnelAdministratifDto>();
	}

	public long getDepartementID() {
		return departementId;
	}

	public void setDepartementID(long departementID) {
		this.departementId = departementID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public EtablissementDto getEtablissementDto() {
		return etablissementDto;
	}

	public void setEtablissementDto(EtablissementDto etablissementDto) {
		this.etablissementDto = etablissementDto;
	}

	public Collection<EnseignantDto> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Collection<EnseignantDto> enseignants) {
		this.enseignants = enseignants;
	}

	public Collection<CursusDto> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(Collection<CursusDto> specialites) {
		this.specialites = specialites;
	}

	public Collection<PersonnelAdministratifDto> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(Collection<PersonnelAdministratifDto> personnels) {
		this.personnels = personnels;
	}

	
}
