package edu.ipsas.edt.dto;


public class RessourceDto {

	private long RessourceID;

	private String nom;

	private SalleDto salleDto;

	public RessourceDto() {
		super();
	}

	public RessourceDto(String nom) {
		super();
		this.nom = nom;
	}

	public RessourceDto(String nom, SalleDto salleDto) {
		super();
		this.nom = nom;
		this.salleDto = salleDto;
	}

	public long getRessourceID() {
		return RessourceID;
	}

	public void setRessourceID(long ressourceID) {
		RessourceID = ressourceID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public SalleDto getSalleDto() {
		return salleDto;
	}

	public void setSalleDto(SalleDto salleDto) {
		this.salleDto = salleDto;
	}

}
