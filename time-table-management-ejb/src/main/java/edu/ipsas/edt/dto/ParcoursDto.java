package edu.ipsas.edt.dto;


public class ParcoursDto {

	private long parcoursId;

	private String nom;
	
	private CursusDto cursusDto;

	public ParcoursDto() {
		super();
	}

	public ParcoursDto(String nom, CursusDto specialiteDto) {
		super();
		this.nom = nom;
		this.cursusDto = specialiteDto;
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
}
