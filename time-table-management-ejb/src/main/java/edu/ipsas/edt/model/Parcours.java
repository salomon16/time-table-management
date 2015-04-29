package edu.ipsas.edt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PARCOURS")
public class Parcours implements Serializable {
	
	@Id
	@Column(name="PARCOURS_ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long parcoursId;
	
	@Column(name="NOM", unique = true, nullable = false)
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "CURSUS_ID")
	private Cursus cursus;

	public Parcours() {
		super();
	}

	public Parcours(String nom, String abbreviation, Cursus cursus) {
		super();
		this.nom = nom;
		this.cursus = cursus;
		cursus.getParcours().add(this);
	}

	public long getParcoursID() {
		return parcoursId;
	}

	public void setParcoursID(long parcoursID) {
		this.parcoursId = parcoursID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Cursus getCursus() {
		return cursus;
	}

	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}

}
