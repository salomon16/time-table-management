package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class GroupeDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long groupeId;
	private String nom;
	private String abbreviation;
	private Collection<EmploiDto> emploiDto;
	private NiveauDto niveauDto;
	
	public GroupeDto() {
		super();
		emploiDto = new ArrayList<EmploiDto>();
	}
	public GroupeDto(Collection<EmploiDto> emploiDto, NiveauDto niveauDto) {
		super();
		this.emploiDto = emploiDto;
		this.niveauDto = niveauDto;
	}
	public long getGroupeId() {
		return groupeId;
	}
	public void setGroupeId(long groupeId) {
		this.groupeId = groupeId;
	}
	public Collection<EmploiDto> getEmploiDto() {
		return emploiDto;
	}
	public void setEmploiDto(Collection<EmploiDto> emploiDto) {
		this.emploiDto = emploiDto;
	}
	public NiveauDto getNiveauDto() {
		return niveauDto;
	}
	public void setNiveauDto(NiveauDto niveauDto) {
		this.niveauDto = niveauDto;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

}
