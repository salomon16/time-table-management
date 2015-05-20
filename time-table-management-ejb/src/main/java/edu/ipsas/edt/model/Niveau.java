package edu.ipsas.edt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NIVEAU")
public class Niveau implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NIVEAU_ID", unique=true , nullable=false)
	private long niveauId;
	
	@Column(name="NOM", unique=true , nullable=false)
	private String nom;
	
	@Column(name="ABBREVIATION", unique=true , nullable=true)
	private String abbreviation;
	
	@ManyToOne
	@JoinColumn(name="PARCOURS_ID")
	private Parcours parcours;
	
	@OneToMany
	private Collection<Groupe> groupes;

	public Niveau() {
		super();
		groupes = new ArrayList<Groupe>();
	}

	public Niveau(String nom, String abbreviation) {
		super();
		this.nom = nom;
		this.abbreviation = abbreviation;
		groupes = new ArrayList<Groupe>();
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

	public Collection<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Parcours getParcours() {
		return parcours;
	}

	public void setParcours(Parcours parcours) {
		this.parcours = parcours;
	}
	
	
	
}
