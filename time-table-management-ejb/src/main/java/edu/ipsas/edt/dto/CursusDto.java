package edu.ipsas.edt.dto;

import java.util.ArrayList;
import java.util.Collection;

public class CursusDto {

	private long cursusId;
	private String nom;
	private Collection<ParcoursDto> parcours;
	private DepartementDto departementDto;

	public CursusDto() {
		super();
		parcours = new ArrayList<ParcoursDto>();
	}

	public CursusDto(String nom, DepartementDto departementDto) {
		super();
		this.nom = nom;
		this.departementDto = departementDto;
		this.parcours = new ArrayList<ParcoursDto>();
	}

	public long getCursusId() {
		return cursusId;
	}

	public void setCursusId(long cursusId) {
		this.cursusId = cursusId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<ParcoursDto> getParcours() {
		return parcours;
	}

	public void setParcours(Collection<ParcoursDto> parcours) {
		this.parcours = parcours;
	}

	public DepartementDto getDepartementDto() {
		return departementDto;
	}

	public void setDepartementDto(DepartementDto departementDto) {
		this.departementDto = departementDto;
	}

}
