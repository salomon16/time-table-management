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
@Table(name="GROUPE")
public class Groupe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GROUPE_ID",unique=true, nullable=false)
	private long groupeId;
	
	@Column(name="NOM", unique=false, nullable=true)
	private String nom;
	
	@Column(name="ABBREVIATION", unique=false, nullable=true)
	private String abbreviation;
	
	@OneToMany
	private Collection<Emploi> emploi;
	
	@ManyToOne
	@JoinColumn(name="NIVEAU_ID")
	private Niveau niveau;

	
	public Groupe() {
		super();
		emploi = new ArrayList<Emploi>();
	}

	public Groupe(String nom, String abbreviation, Niveau niveau) {
		super();
		this.nom = nom;
		this.abbreviation = abbreviation;
		this.niveau = niveau;
		niveau.getGroupes().add(this);
	}


	public Groupe(Collection<Emploi> emploi, Niveau niveau) {
		super();
		this.emploi = emploi;
		this.niveau = niveau;
		niveau.getGroupes().add(this);
	}


	public long getGroupeId() {
		return groupeId;
	}

	public void setGroupeId(long groupeId) {
		this.groupeId = groupeId;
	}

	public Collection<Emploi> getEmploi() {
		return emploi;
	}

	public void setEmploi(Collection<Emploi> emploi) {
		this.emploi = emploi;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
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

}
