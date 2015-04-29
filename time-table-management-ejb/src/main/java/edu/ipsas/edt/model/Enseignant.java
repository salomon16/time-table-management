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
@Table(name = "ENSEIGNANT")
@SuppressWarnings("serial")
public class Enseignant extends Personne implements Serializable {

	@Id
	@Column(name="ENSEIGNANT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long enseignantId;
	
	@Column(name="SPECIALITE", unique = true, nullable = false)
	private String specialite;
	
	@OneToMany
	private Collection<Departement> departements;
	
	@OneToMany
	private Collection<Disponibilite> disponibilites;

	@ManyToOne
	@JoinColumn(name = "GRADE_ID")
	private Grade grade;
	
	@ManyToOne
	@JoinColumn(name = "STATUT_ID")
	private Statut statut;

	public Enseignant() {
		super();
		departements = new ArrayList<Departement>();
		disponibilites = new ArrayList<Disponibilite>();
		
	}

	public Enseignant(String nom, String prenom, String cin, String adresse,
			String telephoneMobile, String email) {
		super(nom, prenom, cin, adresse, telephoneMobile, email);
		departements = new ArrayList<Departement>();
		disponibilites = new ArrayList<Disponibilite>();
		
	}

	public Enseignant(String nom, String prenom, String cin, String adresse,
			String telephoneMobile, String email, String specialite,
			Statut statut) {
		super(nom, prenom, cin, adresse, telephoneMobile, email);
		this.statut = statut;
		this.specialite = specialite;
		departements = new ArrayList<Departement>();
		disponibilites = new ArrayList<Disponibilite>();

	}

	public long getEnseignantID() {
		return enseignantId;
	}

	public void setEnseignantID(long enseignantID) {
		enseignantId = enseignantID;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Collection<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(Collection<Departement> departements) {
		this.departements = departements;
	}

	public Collection<Disponibilite> getDisponibilites() {
		return disponibilites;
	}

	public void setDisponibilites(Collection<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

}
