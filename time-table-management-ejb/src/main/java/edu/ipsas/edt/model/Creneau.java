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
@Table(name = "CRENEAU")
public class Creneau implements Serializable {

	@Id
	@Column(name = "CRENEAU_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long creneauId;
	
//	@Column(name = "HEURE_DEBUT", unique = true, nullable = false)
//	private Date heureDebut;
//	
//	@Column(name = "HEURE_FIN", unique = true, nullable = false)
//	private Date heureFin;
	@Column(name = "ORDRE", unique = true, nullable = false)
	private int ordre;
	
	@Column(name = "LIBELLE", unique = true, nullable = false)
	private String libelle;
	
	@OneToMany
	@JoinTable(name="CRENEAU_SEANCES", 
    joinColumns=@JoinColumn(name="CRENEAU_ID"),
    inverseJoinColumns=@JoinColumn(name="SEANCE_ID"))
	private Collection<Seance> seances;
	
	@OneToMany
	 @JoinTable
	  (
	      name="CRENEAU_DISPONIBILITES",
	      joinColumns={ @JoinColumn(name="CRENEAU_ID", referencedColumnName="CRENEAU_ID") },
	      inverseJoinColumns={ @JoinColumn(name="DISPONIBILITE_ID", referencedColumnName="DISPONIBILITE_ID", unique=true) }
	  )
	private Collection<Disponibilite> disponibilites;

	public Creneau() {
		super();
		disponibilites = new ArrayList<Disponibilite>();
		seances = new ArrayList<Seance>();
	}

	
	public long getCreneauID() {
		return creneauId;
	}

	public void setCreneauID(long creneauID) {
		creneauId = creneauID;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Collection<Disponibilite> getDisponibilites() {
		return disponibilites;
	}

	public void setDisponibilites(Collection<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}

	public long getCreneauId() {
		return creneauId;
	}

	public void setCreneauId(long creneauId) {
		this.creneauId = creneauId;
	}

	public Collection<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Collection<Seance> seances) {
		this.seances = seances;
	}

	
}
