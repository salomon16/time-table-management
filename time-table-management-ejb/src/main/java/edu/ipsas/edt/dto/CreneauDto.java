package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.model.Seance;

public class CreneauDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long CreneauID;

//	private Date heureDebut;
//
//	private Date heureFin;

	private int ordre;
	
	private String libelle;
	
	private Collection<DisponibiliteDto> disponibilites;

	private Collection<Seance> seances;

	public CreneauDto() {
		super();
		disponibilites = new ArrayList<DisponibiliteDto>();
		seances = new ArrayList<Seance>();
	}


	public long getCreneauID() {
		return CreneauID;
	}

	public void setCreneauID(long creneauID) {
		CreneauID = creneauID;
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


	public Collection<DisponibiliteDto> getDisponibilites() {
		return disponibilites;
	}

	public void setDisponibilites(Collection<DisponibiliteDto> disponibilites) {
		this.disponibilites = disponibilites;
	}

	public Collection<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Collection<Seance> seances) {
		this.seances = seances;
	}

}
