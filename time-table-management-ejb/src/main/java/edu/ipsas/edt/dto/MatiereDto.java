package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class MatiereDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long matiereId;

	private String nom;
	
	private float nombreHeure;

	private String description;

	private String type;

	private float volumeC;

	private float volumeTp;

	private float volumeTd;

	private float credit;

	private int coefficient;

	private UniteDto uniteDto;

	private Collection<PlanEtudeDto> plansEtudeDto;
	
	public MatiereDto() {
		super();
		plansEtudeDto = new ArrayList<PlanEtudeDto>();
	}

	public MatiereDto(String nom, String description, String type, float volumeC,
			float volumeTp, float volumeTd, float credit, int coefficient,
			UniteDto uniteDto) {
		super();
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.volumeC = volumeC;
		this.volumeTp = volumeTp;
		this.volumeTd = volumeTd;
		this.credit = credit;
		this.coefficient = coefficient;
		this.uniteDto = uniteDto;
		plansEtudeDto = new ArrayList<PlanEtudeDto>();
	}

	public MatiereDto(String nom, float nombreHeure, String type, float volumeC, float volumeTp,
			float volumeTd, float credit, int coefficient) {
		super();
		this.nom = nom;
		this.nombreHeure = nombreHeure;
		this.type = type;
		this.volumeC = volumeC;
		this.volumeTp = volumeTp;
		this.volumeTd = volumeTd;
		this.credit = credit;
		this.coefficient = coefficient;
		plansEtudeDto = new ArrayList<PlanEtudeDto>();
	}

	public long getMatiereId() {
		return matiereId;
	}

	public void setMatiereId(long matiereId) {
		this.matiereId = matiereId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getVolumeC() {
		return volumeC;
	}

	public void setVolumeC(float volumeC) {
		this.volumeC = volumeC;
	}

	public float getVolumeTp() {
		return volumeTp;
	}

	public void setVolumeTp(float volumeTP) {
		this.volumeTp = volumeTP;
	}

	public float getVolumeTd() {
		return volumeTd;
	}

	public void setVolumeTd(float volumeTD) {
		this.volumeTd = volumeTD;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public UniteDto getUniteDto() {
		return uniteDto;
	}

	public void setUniteDto(UniteDto uniteDto) {
		this.uniteDto = uniteDto;
	}

	public Collection<PlanEtudeDto> getPlansEtudeDto() {
		return plansEtudeDto;
	}

	public void setPlansEtudeDto(Collection<PlanEtudeDto> plansEtudeDto) {
		this.plansEtudeDto = plansEtudeDto;
	}

	public float getNombreHeure() {
		return nombreHeure;
	}

	public void setNombreHeure(float nombreHeure) {
		this.nombreHeure = nombreHeure;
	}
	
}
