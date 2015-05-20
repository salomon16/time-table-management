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

	private int heureDebut;

	private int heureFin;

	private Collection<DisponibiliteDto> disponibilites;

	private Collection<Seance> seances;

	public CreneauDto() {
		super();
		disponibilites = new ArrayList<DisponibiliteDto>();
		seances = new ArrayList<Seance>();
	}

	public CreneauDto(int heureDebut, int heureFin) {
		super();
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		disponibilites = new ArrayList<DisponibiliteDto>();
		seances = new ArrayList<Seance>();
	}

	public long getCreneauID() {
		return CreneauID;
	}

	public void setCreneauID(long creneauID) {
		CreneauID = creneauID;
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
