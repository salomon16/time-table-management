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
	
	@Column(name = "HEURE_DEBUT", unique = true, nullable = false)
	private int heureDebut;
	
	@Column(name = "HEURE_FIN", unique = true, nullable = false)
	private int heureFin;

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
	}

	public Creneau(int heureDebut, int heureFin) {
		super();
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	public long getCreneauID() {
		return creneauId;
	}

	public void setCreneauID(long creneauID) {
		creneauId = creneauID;
	}

	public int getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}

	public int getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}

	public Collection<Disponibilite> getDisponibilites() {
		return disponibilites;
	}

	public void setDisponibilites(Collection<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}

}
