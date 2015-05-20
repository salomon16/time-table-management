package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public class NiveauDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long niveauId;
	
	private String nom;
	
	private String abbreviation;
	
	private ParcoursDto parcoursDto;
	
	private Collection<GroupeDto> groupesDto;
	
	public NiveauDto() {
		super();
		groupesDto = new ArrayList<GroupeDto>();
		
	}

	public NiveauDto(String nom, String abbreviation) {
		super();
		this.nom = nom;
		this.abbreviation = abbreviation;
		groupesDto = new ArrayList<GroupeDto>();
	}

	public long getNiveauId() {
		return niveauId;
	}

	public void setNiveauId(long niveauId) {
		this.niveauId = niveauId;
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

	public Collection<GroupeDto> getGroupesDto() {
		return groupesDto;
	}

	public void setGroupesDto(Collection<GroupeDto> groupesDto) {
		this.groupesDto = groupesDto;
	}

	public ParcoursDto getParcoursDto() {
		return parcoursDto;
	}

	public void setParcoursDto(ParcoursDto parcoursDto) {
		this.parcoursDto = parcoursDto;
	}
	
	
}
