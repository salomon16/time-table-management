package edu.ipsas.edt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "GRADE")
public class Grade implements Serializable {

	@Id
	@Column(name="GRADE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gradeID;
	
	@Column(name="NOM", unique = true, nullable = false)
	private String nom;
	
	@OneToMany
	private Collection<Enseignant> enseignants;

	public Grade() {
		super();
		enseignants = new ArrayList<Enseignant>();
	}

	public Grade(String nom) {
		super();
		this.nom = nom;
		enseignants = new ArrayList<Enseignant>();
	}

	public long getGradeID() {
		return gradeID;
	}

	public void setGradeID(long gradeID) {
		this.gradeID = gradeID;
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
