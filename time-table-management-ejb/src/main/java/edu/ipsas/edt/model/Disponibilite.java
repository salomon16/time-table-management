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
@Table(name = "DISPONIBILITE")
public class Disponibilite implements Serializable {

	@Id
	@Column(name="DISPONIBILITE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long disponibiliteId;
	
	@Column(name="JOUR", unique = true, nullable = false)
	private String jour;
	
	@ManyToOne
	@JoinColumn(name = "ENSEIGNANT_ID")
	private Enseignant enseignant;
	
	@ManyToOne
	@JoinColumn(name = "CRENEAU_ID")
	private Creneau creneau;

	public Disponibilite() {
		super();

	}

	public Disponibilite(String jour) {
		super();
		this.jour = jour;
	}

	public Disponibilite(String jour, Enseignant enseignant, Creneau creneau) {
		super();
		this.jour = jour;
		this.enseignant = enseignant;
		this.creneau = creneau;
	}

	public long getDisponibiliteID() {
		return disponibiliteId;
	}

	public void setDisponibiliteID(long disponibiliteID) {
		this.disponibiliteId = disponibiliteID;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

}
