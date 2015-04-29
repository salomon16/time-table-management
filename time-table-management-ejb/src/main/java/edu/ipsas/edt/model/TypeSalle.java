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
@Table(name = "TYPESALLE")
public class TypeSalle implements Serializable {

	@Id
	@Column(name="TYPE_SALLE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long typeSalleId;
	
	@Column(name="NOM", unique = true, nullable = false)
	private String nom;
	
	@OneToMany
	private Collection<Salle> salles;

	public TypeSalle() {
		super();
		salles = new ArrayList<Salle>();
	}

	public TypeSalle(String nom) {
		super();
		this.nom = nom;
		salles = new ArrayList<Salle>();
	}

	public long getTypeSalleId() {
		return typeSalleId;
	}

	public void setTypeSalleId(long typeSalleID) {
		this.typeSalleId = typeSalleID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Salle> getSalles() {
		return salles;
	}

	public void setSalles(Collection<Salle> salles) {
		this.salles = salles;
	}


}
