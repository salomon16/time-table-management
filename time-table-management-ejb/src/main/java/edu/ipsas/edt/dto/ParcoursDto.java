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
	
	private String abbreviation;
	
	private CursusDto cursusDto;
	
	private Collection<NiveauDto> niveauxDto;
	
	private Collection<PlanEtudeDto> plansEtudeDto;
	
	public ParcoursDto() {
		super();
		niveauxDto = new ArrayList<NiveauDto>();
		plansEtudeDto = new ArrayList<PlanEtudeDto>();
	}

	public ParcoursDto(String nom,String abbreviation, CursusDto specialiteDto) {
		super();
		this.nom = nom;
		this.abbreviation = abbreviation;
		this.cursusDto = specialiteDto;
		plansEtudeDto = new ArrayList<PlanEtudeDto>();
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

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Collection<NiveauDto> getNiveauxDto() {
		return niveauxDto;
	}

	public void setNiveauxDto(Collection<NiveauDto> niveauxDto) {
		this.niveauxDto = niveauxDto;
	}
	
}
