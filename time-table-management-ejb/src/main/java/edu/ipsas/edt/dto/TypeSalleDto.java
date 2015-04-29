package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class TypeSalleDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long typeSalleId;

	private String nom;
	
	private Collection<SalleDto> salles;

	public TypeSalleDto() {
		super();
		salles = new ArrayList<SalleDto>();
	}

	public TypeSalleDto(String nom, int capacite) {
		super();
		this.nom = nom;
		salles = new ArrayList<SalleDto>();
	}

	public long getTypeSalleId() {
		return typeSalleId;
	}

	public void setTypeSalleId(long typeSalleID) {
		this.typeSalleId = typeSalleID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<SalleDto> getSalles() {
		return salles;
	}

	public void setSalles(Collection<SalleDto> salles) {
		this.salles = salles;
	}

}
