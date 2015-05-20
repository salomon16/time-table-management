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

@Entity
@Table(name="UNITE")
public class Unite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UNITE_ID", nullable=false, unique=true)
	private long uniteId;
	
	@Column(name="NOM", nullable=false, unique=true)
	private String nom;
	
	@OneToMany
	private Collection<Matiere> matieres;

	
	public Unite() {
		super();
		matieres = new  ArrayList<Matiere>();
	}

	public Unite(String nom) {
		super();
		this.nom = nom;
		matieres = new  ArrayList<Matiere>();
	}

	public long getUniteId() {
		return uniteId;
	}

	public void setUniteId(long uniteId) {
		this.uniteId = uniteId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Collection<Matiere> matieres) {
		this.matieres = matieres;
	}


}
