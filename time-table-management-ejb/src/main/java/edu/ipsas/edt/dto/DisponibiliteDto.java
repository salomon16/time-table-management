package edu.ipsas.edt.dto;


public class DisponibiliteDto {

	private long disponibiliteID;
	private String jour;
	private EnseignantDto enseignantDto;
	private CreneauDto creneauDto;

	public DisponibiliteDto() {
		super();

	}

	public DisponibiliteDto(String jour) {
		super();
		this.jour = jour;
	}

	public DisponibiliteDto(String jour, EnseignantDto enseignantDto, CreneauDto creneauDto) {
		super();
		this.jour = jour;
		this.enseignantDto = enseignantDto;
		this.creneauDto = creneauDto;
	}

	public long getDisponibiliteID() {
		return disponibiliteID;
	}

	public void setDisponibiliteID(long disponibiliteID) {
		this.disponibiliteID = disponibiliteID;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public EnseignantDto getEnseignantDto() {
		return enseignantDto;
	}

	public void setEnseignantDto(EnseignantDto enseignantDto) {
		this.enseignantDto = enseignantDto;
	}

	public CreneauDto getCreneauDto() {
		return creneauDto;
	}

	public void setCreneauDto(CreneauDto creneauDto) {
		this.creneauDto = creneauDto;
	}
}
