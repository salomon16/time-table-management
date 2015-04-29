package edu.ipsas.edt.dto;

import java.util.ArrayList;
import java.util.Collection;

public class CreneauDto {
	private long CreneauID;

	private int heureDebut;

	private int heureFin;

	private Collection<DisponibiliteDto> disponibilites;

	public CreneauDto() {
		super();
		disponibilites = new ArrayList<DisponibiliteDto>();
	}

	public CreneauDto(int heureDebut, int heureFin) {
		super();
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
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

}
