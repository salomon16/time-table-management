package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public class ParcoursDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long parcoursId;

	private String nom;
	
	private CursusDto cursusDto;
	
	private Collection<PlanEtudeDto> plansEtudeDto;
	
	public ParcoursDto() {
		super();
		plansEtudeDto = new ArrayList<PlanEtudeDto>();
	}

	public ParcoursDto(String nom, CursusDto specialiteDto) {
		super();
		this.nom = nom;
		this.cursusDto = specialiteDto;
		plansEtudeDto = new ArrayList<PlanEtudeDto>();
	}

	public long getParcoursID() {
		return parcoursId;
	}

	public void setParcoursID(long parcoursID) {
		this.parcoursId = parcoursID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public CursusDto getCursusDto() {
		return cursusDto;
	}

	public void setCursusDto(CursusDto specialiteDto) {
		this.cursusDto = specialiteDto;
	}

	public long getParcoursId() {
		return parcoursId;
	}

	public void setParcoursId(long parcoursId) {
		this.parcoursId = parcoursId;
	}

	public Collection<PlanEtudeDto> getPlansEtudeDto() {
		return plansEtudeDto;
	}

	public void setPlansEtudeDto(Collection<PlanEtudeDto> plansEtudeDto) {
		this.plansEtudeDto = plansEtudeDto;
	}
	
	
}
