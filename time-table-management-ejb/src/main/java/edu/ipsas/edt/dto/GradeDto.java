package edu.ipsas.edt.dto;

import java.util.ArrayList;
import java.util.Collection;

public class GradeDto {

	private long gradeID;

	private String nom;
	
	private Collection<EnseignantDto> enseignants;

	public GradeDto() {
		super();
		enseignants = new ArrayList<EnseignantDto>();
	}

	public GradeDto(String nom) {
		super();
		this.nom = nom;
		enseignants = new ArrayList<EnseignantDto>();
	}

	public long getGradeID() {
		return gradeID;
	}

	public void setGradeID(long gradeID) {
		this.gradeID = gradeID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<EnseignantDto> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Collection<EnseignantDto> enseignants) {
		this.enseignants = enseignants;
	}

	
}
