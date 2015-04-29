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
@Table(name = "RESSOURCE")
public class Ressource implements Serializable {

	@Id
	@Column(name="RESSOURCE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ressourceId;
	
	@Column(name="NOM", unique = true, nullable = false)
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "SALLE_ID")
	private Salle salle;

	public Ressource() {
		super();
	}

	public Ressource(String nom) {
		super();
		this.nom = nom;
	}

	public Ressource(String nom, Salle salle) {
		super();
		this.nom = nom;
		this.salle = salle;
	}

	public long getRessourceID() {
		return ressourceId;
	}

	public void setRessourceID(long ressourceID) {
		ressourceId = ressourceID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

}
