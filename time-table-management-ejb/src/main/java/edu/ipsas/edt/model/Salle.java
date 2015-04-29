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
@Table(name = "SALLE")
public class Salle implements Serializable {

	@Id
	@Column(name = "SALLE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long salleId;

	@Column(name = "NUMERO", unique = true, nullable = false)
	private String numero;

	@Column(name = "CAPACITE", unique = false, nullable = true)
	private int capacite;

	@ManyToOne
	@JoinColumn(name = "ETABLISSEMENT_ID")
	private Etablissement etablissement;

	@OneToMany
	@JoinTable(name = "SALLE_RESSOURCES", joinColumns = { @JoinColumn(name = "SALLE_ID", referencedColumnName = "SALLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "RESSOURCE_ID", referencedColumnName = "RESSOURCE_ID", unique = true) })
	private Collection<Ressource> ressources;

	@ManyToOne
	@JoinColumn(name = "TYPE_SALLE_ID")
	private TypeSalle typeSalle;

	public Salle() {
		super();
		ressources = new ArrayList<Ressource>();
	}

	public Salle(String numero, int capacite) {
		super();
		this.numero = numero;
		this.capacite = capacite;
	}

	public Salle(String numero, Etablissement etablissement, TypeSalle typeSalle) {
		super();
		this.numero = numero;
		this.etablissement = etablissement;
		this.typeSalle = typeSalle;
		typeSalle.getSalles().add(this);
		ressources = new ArrayList<Ressource>();
	}

	public long getSalleId() {
		return salleId;
	}

	public void setSalleId(long salleId) {
		this.salleId = salleId;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public Collection<Ressource> getRessources() {
		return ressources;
	}

	public void setRessources(Collection<Ressource> ressources) {
		this.ressources = ressources;
	}

	public TypeSalle getTypeSalle() {
		return typeSalle;
	}

	public void setTypeSalle(TypeSalle typeSalle) {
		this.typeSalle = typeSalle;
	}

}
