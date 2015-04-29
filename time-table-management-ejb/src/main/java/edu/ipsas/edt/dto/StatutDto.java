package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class StatutDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long statutId;

	private String nom;
	
	private Collection<EnseignantDto> enseignants;

	public StatutDto() {
		super();
		enseignants = new ArrayList<EnseignantDto>();
	}

	public StatutDto(String nom) {
		super();
		this.nom = nom;
		enseignants = new ArrayList<EnseignantDto>();
	}

	public long getStatutID() {
		return statutId;
	}

	public void setStatutID(long statutID) {
		this.statutId = statutID;
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
