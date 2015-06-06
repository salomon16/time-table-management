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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PARCOURS")
public class Parcours implements Serializable {
	
	@Id
	@Column(name="PARCOURS_ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long parcoursId;
	
	@Column(name="NOM", unique = false, nullable = true)
	private String nom;
	
	@Column(name="ABBREVIATION", unique = false, nullable = true)
	private String abbreviation;
	
	@ManyToOne
	@JoinColumn(name = "CURSUS_ID")
	private Cursus cursus;

	@OneToMany
	@JoinTable(name="PARCOURS_NIVEAUX", 
    joinColumns=@JoinColumn(name="PARCOURS_ID"),
    inverseJoinColumns=@JoinColumn(name="NIVEAU_ID"))
	private Collection<Niveau> niveaux;
	
	@OneToMany
	@JoinTable(name="PARCOURS_PLANS_ETUDE", 
    joinColumns=@JoinColumn(name="PARCOURS_ID"),
    inverseJoinColumns=@JoinColumn(name="PLAN_ETUDE_ID"))
	private Collection<PlanEtude> plansEtude;
	
	public Parcours() {
		super();
		niveaux = new ArrayList<Niveau>();
		plansEtude = new ArrayList<PlanEtude>();
	}

	public Parcours(String nom, String abbreviation, Cursus cursus) {
		super();
		this.nom = nom;
		this.abbreviation = abbreviation;
		this.cursus = cursus;
		niveaux = new ArrayList<Niveau>();
		cursus.getParcours().add(this);
		plansEtude = new ArrayList<PlanEtude>();
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

	public long getParcoursId() {
		return parcoursId;
	}

	public void setParcoursId(long parcoursId) {
		this.parcoursId = parcoursId;
	}

	public Collection<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(Collection<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	public Collection<PlanEtude> getPlansEtude() {
		return plansEtude;
	}

	public void setPlansEtude(Collection<PlanEtude> plansEtude) {
		this.plansEtude = plansEtude;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	
}
