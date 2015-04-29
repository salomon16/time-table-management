package edu.ipsas.edt.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NIVEAU")
public class Niveau {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NIVEAU_ID", unique=true , nullable=false)
	private long niveauId;
	
	@Column(name="NOM", unique=true , nullable=false)
	private String nom;
	
	@Column(name="ABBREVIATION", unique=true , nullable=true)
	private String abbreviation;
	
	@OneToMany
	private Collection<Parcours> parcours;

	public Niveau() {
		super();
		parcours = new ArrayList<Parcours>();
	}

	public Niveau(String nom, String abbreviation) {
		super();
		this.nom = nom;
		this.abbreviation = abbreviation;
		parcours = new ArrayList<Parcours>();
	}

	public long getNiveauId() {
		return niveauId;
	}

	public void setNiveauId(long niveauId) {
		this.niveauId = niveauId;
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

	public Collection<Parcours> getParcours() {
		return parcours;
	}

	public void setParcours(Collection<Parcours> parcours) {
		this.parcours = parcours;
	}
	
	
	
}
