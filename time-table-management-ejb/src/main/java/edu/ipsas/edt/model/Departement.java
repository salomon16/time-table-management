package edu.ipsas.edt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTEMENT")
public class Departement implements Serializable {

	@Id
	@Column(name = "DEPARTEMENT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long departementId;

	@Column(name = "NOM", unique = true, nullable = false)
	private String nom;

	@ManyToOne
	@JoinColumn(name = "ETABLISSEMENT_ID")
	private Etablissement etablissement;

	@OneToMany
	@JoinTable(name="DEPARTEMENT_ENSEIGNANTS", 
    joinColumns=@JoinColumn(name="DEPARTEMENT_ID"),
    inverseJoinColumns=@JoinColumn(name="ENSEIGNANT_ID"))
	private Collection<Enseignant> enseignants;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="DEPARTEMENT_CURSUS", 
    joinColumns=@JoinColumn(name="DEPARTEMENT_ID"),
    inverseJoinColumns=@JoinColumn(name="CURSUS_ID"))
	private Collection<Cursus> cursus;
	
	@OneToMany
	@JoinTable(name="DEPARTEMENT_SALLES", 
    joinColumns=@JoinColumn(name="DEPARTEMENT_ID"),
    inverseJoinColumns=@JoinColumn(name="SALLE_ID"))
	private Collection<Salle> salles;
	
	@OneToMany
	@JoinTable(name="DEPARTEMENT_PERSONNELS", 
    joinColumns=@JoinColumn(name="DEPARTEMENT_ID"),
    inverseJoinColumns=@JoinColumn(name="PERSONNEL_ADMINISTRATIF_ID"))
	private Collection<PersonnelAdministratif> personnels;

	public Departement() {
		super();
		enseignants = new ArrayList<Enseignant>();
		cursus = new ArrayList<Cursus>();
		personnels = new ArrayList<PersonnelAdministratif>();
		salles = new ArrayList<Salle>();
	}

	public Departement(String nom) {
		super();
		this.nom = nom;
		enseignants = new ArrayList<Enseignant>();
		cursus = new ArrayList<Cursus>();
		personnels = new ArrayList<PersonnelAdministratif>();
		salles = new ArrayList<Salle>();
	}

	public Departement(String nom, Etablissement etablissement) {
		super();
		this.nom = nom;
		this.etablissement = etablissement;
		enseignants = new ArrayList<Enseignant>();
		cursus = new ArrayList<Cursus>();
		personnels = new ArrayList<PersonnelAdministratif>();
		salles = new ArrayList<Salle>();
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

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public Collection<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Collection<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public Collection<Cursus> getCursus() {
		return cursus;
	}

	public void setCursus(Collection<Cursus> cursus) {
		this.cursus = cursus;
	}

	public long getDepartementId() {
		return departementId;
	}

	public void setDepartementId(long departementId) {
		this.departementId = departementId;
	}

	public Collection<PersonnelAdministratif> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(Collection<PersonnelAdministratif> personnels) {
		this.personnels = personnels;
	}

	public Collection<Salle> getSalles() {
		return salles;
	}

	public void setSalles(Collection<Salle> salles) {
		this.salles = salles;
	}

	
}
