package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.ipsas.edt.model.Seance;

public class CreneauDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long CreneauID;

	private Date heureDebut;

	private Date heureFin;

	private Collection<DisponibiliteDto> disponibilites;

	private Collection<Seance> seances;

	public CreneauDto() {
		super();
		disponibilites = new ArrayList<DisponibiliteDto>();
		seances = new ArrayList<Seance>();
	}

	public CreneauDto(Date heureDebut, Date heureFin) {
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

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
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
