package edu.ipsas.edt.dto;

import java.io.Serializable;

public class SeanceDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long seanceId;
	private int numero;
	private String jour;
	private EmploiDto emploiDto;
	private CreneauDto creneauDto;
	private MatiereDto matiereDto;
	private SalleDto salleDto;
	private EnseignantDto enseignantDto;
	
	
	public SeanceDto() {
		super();
	}
	
	public SeanceDto(int numero, String jour,
			EmploiDto emploiDto, CreneauDto creneauDto, MatiereDto matiereDto,
			SalleDto salleDto) {
		super();
		this.numero = numero;
		this.jour = jour;
		this.emploiDto = emploiDto;
		this.creneauDto = creneauDto;
		this.matiereDto = matiereDto;
		this.salleDto = salleDto;
	}


	public long getSeanceId() {
		return seanceId;
	}
	public void setSeanceId(long seanceId) {
		this.seanceId = seanceId;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}

	public EmploiDto getEmploiDto() {
		return emploiDto;
	}
	public void setEmploiDto(EmploiDto emploiDto) {
		this.emploiDto = emploiDto;
	}
	public CreneauDto getCreneauDto() {
		return creneauDto;
	}
	public void setCreneauDto(CreneauDto creneauDto) {
		this.creneauDto = creneauDto;
	}
	public MatiereDto getMatiereDto() {
		return matiereDto;
	}
	public void setMatiereDto(MatiereDto matiereDto) {
		this.matiereDto = matiereDto;
	}
	public SalleDto getSalleDto() {
		return salleDto;
	}
	public void setSalleDto(SalleDto salleDto) {
		this.salleDto = salleDto;
	}

	public EnseignantDto getEnseignantDto() {
		return enseignantDto;
	}

	public void setEnseignantDto(EnseignantDto enseignantDto) {
		this.enseignantDto = enseignantDto;
	}
	
	

}
