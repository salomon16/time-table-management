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
@SuppressWarnings("serial")
@Entity
@Table(name = "CURSUS")
public class Cursus implements Serializable{

	@Id
	@Column(name="CURSUS_ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cursusId;
	
	@Column(name="NOM", unique = false, nullable = false)
	private String nom;
	
	@OneToMany
	private Collection<Parcours> parcours;
	
	@ManyToOne
	@JoinColumn(name = "DEPARTEMENT_ID")
	private Departement departement;
	
	public Cursus() {
		super();
		parcours = new ArrayList<Parcours>();
	}

	public Cursus(String nom, Departement departement) {
		super();
		this.nom = nom;
		this.departement = departement;
		parcours = new ArrayList<Parcours>();
		departement.getCursus().add(this);
		
	}

	public long getCursusId() {
		return cursusId;
	}

	public void setCursusId(long cursusId) {
		this.cursusId = cursusId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Parcours> getParcours() {
		return parcours;
	}

	public void setParcours(Collection<Parcours> parcours) {
		this.parcours = parcours;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}
