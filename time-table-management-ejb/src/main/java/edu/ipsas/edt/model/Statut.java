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
import javax.persistence.OneToMany;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name = "STATUT")
public class Statut implements Serializable{

	@Id
	@Column(name="STATUT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long statutId;
	
	@Column(name="NOM", unique = true, nullable = false)
	private String nom;
	
	@OneToMany
	@JoinTable(name="STATUT_ENSEIGNANTS", 
    joinColumns=@JoinColumn(name="STATUT_ID"),
    inverseJoinColumns=@JoinColumn(name="ENSEIGNANT_ID"))
	private Collection<Enseignant> enseignants;

	public Statut() {
		super();
		enseignants = new ArrayList<Enseignant>();
	}

	public Statut(String nom) {
		super();
		this.nom = nom;
		enseignants = new ArrayList<Enseignant>();
	}

	public long getStatutID() {
		return statutId;
	}

	public void setStatutID(long statutID) {
		this.statutId = statutID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Collection<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

}
