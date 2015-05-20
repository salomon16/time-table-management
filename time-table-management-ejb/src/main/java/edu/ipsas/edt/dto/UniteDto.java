package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UniteDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long uniteId;
	
	private String nom;
	
	private Collection<MatiereDto> matieresDto;

	
	public UniteDto() {
		super();
		matieresDto = new ArrayList<MatiereDto>();
	}

	public UniteDto(String nom, List<MatiereDto> matieresDto) {
		super();
		this.nom = nom;
		this.matieresDto = matieresDto;
	}

	public long getUniteId() {
		return uniteId;
	}

	public void setUniteId(long uniteId) {
		this.uniteId = uniteId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<MatiereDto> getMatieresDto() {
		return matieresDto;
	}

	public void setMatieresDto(Collection<MatiereDto> matieresDto) {
		this.matieresDto = matieresDto;
	}

	
	
}
