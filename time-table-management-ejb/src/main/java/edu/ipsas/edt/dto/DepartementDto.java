package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class DepartementDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long departementId;
	private String nom;
	private EtablissementDto etablissementDto;
	private Collection<EnseignantDto> enseignants;
	private Collection<CursusDto> cursus;
	private Collection<SalleDto> salleDto;
	private Collection<PersonnelAdministratifDto> personnels;

	public DepartementDto() {
		super();
		enseignants = new ArrayList<EnseignantDto>();
		cursus = new ArrayList<CursusDto>();
		personnels = new ArrayList<PersonnelAdministratifDto>();
		salleDto = new ArrayList<SalleDto>();
	}

	public DepartementDto(String nom) {
		super();
		this.nom = nom;
		enseignants = new ArrayList<EnseignantDto>();
		cursus = new ArrayList<CursusDto>();
		personnels = new ArrayList<PersonnelAdministratifDto>();
		salleDto = new ArrayList<SalleDto>();
	}

	public DepartementDto(String nom, EtablissementDto etablissementDto) {
		super();
		this.nom = nom;
		this.etablissementDto = etablissementDto;
		enseignants = new ArrayList<EnseignantDto>();
		cursus = new ArrayList<CursusDto>();
		personnels = new ArrayList<PersonnelAdministratifDto>();
		salleDto = new ArrayList<SalleDto>();
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
		return cursus;
	}

	public void setSpecialites(Collection<CursusDto> specialites) {
		this.cursus = specialites;
	}

	public Collection<PersonnelAdministratifDto> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(Collection<PersonnelAdministratifDto> personnels) {
		this.personnels = personnels;
	}

	public long getDepartementId() {
		return departementId;
	}

	public void setDepartementId(long departementId) {
		this.departementId = departementId;
	}

	public Collection<CursusDto> getCursus() {
		return cursus;
	}

	public void setCursus(Collection<CursusDto> cursus) {
		this.cursus = cursus;
	}

	public Collection<SalleDto> getSalleDto() {
		return salleDto;
	}

	public void setSalleDto(Collection<SalleDto> salleDto) {
		this.salleDto = salleDto;
	}

	
}
