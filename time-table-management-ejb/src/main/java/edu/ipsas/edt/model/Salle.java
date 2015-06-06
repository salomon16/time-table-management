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

	@Column(name = "DISPONIBLE", unique = false, nullable = true)
	private boolean disponible=true;
	
	@OneToMany
	@JoinTable(name = "SALLE_RESSOURCES", joinColumns = { @JoinColumn(name = "SALLE_ID", referencedColumnName = "SALLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "RESSOURCE_ID", referencedColumnName = "RESSOURCE_ID", unique = true) })
	private Collection<Ressource> ressources;

	@Column(name = "TYPE_SALLE", unique = false, nullable = true)
	private String typeSalle;
	
	@OneToMany
	@JoinTable(name="SALLE_DEPARTEMENTS", 
    joinColumns=@JoinColumn(name="SALLE_ID"),
    inverseJoinColumns=@JoinColumn(name="DEPARTEMENT_ID"))
	private Collection<Departement> departements;
	
	@OneToMany
	@JoinTable(name="SALLE_SEANCES", 
    joinColumns=@JoinColumn(name="SALLE_ID"),
    inverseJoinColumns=@JoinColumn(name="SEANCE_ID"))
	private Collection<Seance> seances;

	public Salle() {
		super();
		ressources = new ArrayList<Ressource>();
		seances = new ArrayList<Seance>();
		departements = new ArrayList<Departement>();
	}

	
	public Salle(String numero, int capacite, String typeSalle,
			Departement departement) {
		super();
		this.numero = numero;
		this.capacite = capacite;
		this.typeSalle = typeSalle;
		ressources = new ArrayList<Ressource>();
		seances = new ArrayList<Seance>();
		departements = new ArrayList<Departement>();
		
	}


	public Salle(String numero, int capacite) {
		super();
		this.numero = numero;
		this.capacite = capacite;
	}

	public Salle(String numero, String typeSalle) {
		super();
		this.numero = numero;
		this.typeSalle = typeSalle;
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

	public Collection<Ressource> getRessources() {
		return ressources;
	}

	public void setRessources(Collection<Ressource> ressources) {
		this.ressources = ressources;
	}

	public String getTypeSalle() {
		return typeSalle;
	}

	public void setTypeSalle(String typeSalle) {
		this.typeSalle = typeSalle;
	}

	public Collection<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Collection<Seance> seances) {
		this.seances = seances;
	}

	public Collection<Departement> getDepartements() {
		return departements;
	}


	public void setDepartements(Collection<Departement> departements) {
		this.departements = departements;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	
}
