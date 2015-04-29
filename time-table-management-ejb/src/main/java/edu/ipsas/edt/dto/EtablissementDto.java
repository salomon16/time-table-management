package edu.ipsas.edt.dto;

import java.util.ArrayList;
import java.util.Collection;

public class EtablissementDto {

	private String etablissementID;

	private String nom;

	private String abbreviation;

	private String logo;

	private String adresse;
	
	private Collection<DepartementDto> departements;
	
	private Collection<SalleDto> salles;

	public EtablissementDto() {
		super();
		departements = new ArrayList<DepartementDto>();
		salles = new ArrayList<SalleDto>();
	}

	public EtablissementDto(String nom, String abbreviation, String adresse) {
		super();
		this.nom = nom;
		this.abbreviation = abbreviation;
		this.adresse = adresse;
		departements = new ArrayList<DepartementDto>();
		salles = new ArrayList<SalleDto>();
	}

	public String getEtablissementID() {
		return etablissementID;
	}

	public void setEtablissementID(String etablissementID) {
		this.etablissementID = etablissementID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Collection<DepartementDto> getDepartements() {
		return departements;
	}

	public void setDepartements(Collection<DepartementDto> departements) {
		this.departements = departements;
	}

	public Collection<SalleDto> getSalles() {
		return salles;
	}

	public void setSalles(Collection<SalleDto> salles) {
		this.salles = salles;
	}

	
}
