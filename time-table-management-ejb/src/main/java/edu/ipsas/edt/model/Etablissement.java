package edu.ipsas.edt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ETABLISSEMENT")
public class Etablissement implements Serializable {

	@Id
	@Column(name = "ETABLISSEMENT_ID", unique = true, nullable = false)
	private String etablissementId;

	@Column(name = "NOM", unique = true, nullable = false)
	private String nom;

	@Column(name = "ABBREVIATION", unique = true, nullable = false)
	private String abbreviation;

	@Column(name = "ADRESSE", unique = true, nullable = false)
	private String adresse;
	
	@Column(name = "LOGO", unique = true, nullable = false)
	private String logo;
	
	@OneToMany
	@JoinTable(name="DEPARTEMENT_ETABLISSEMENT", 
    joinColumns=@JoinColumn(name="ETABLISSEMENT_ID"),
    inverseJoinColumns=@JoinColumn(name="DEPARTEMENT_ID"))
	private Collection<Departement> departements;


	public Etablissement() {
		super();
		departements = new ArrayList<Departement>();
	}

	public Etablissement(String nom, String abbreviation, String adresse, String logo) {
		super();
		this.nom = nom;
		this.abbreviation = abbreviation;
		this.adresse = adresse;
		this.logo = logo;
		departements = new ArrayList<Departement>();
	}

	public String getEtablissementID() {
		return etablissementId;
	}

	public void setEtablissementID(String etablissementID) {
		this.etablissementId = etablissementID;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Collection<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(Collection<Departement> departements) {
		this.departements = departements;
	}

	public String getEtablissementId() {
		return etablissementId;
	}

	public void setEtablissementId(String etablissementId) {
		this.etablissementId = etablissementId;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}


}
