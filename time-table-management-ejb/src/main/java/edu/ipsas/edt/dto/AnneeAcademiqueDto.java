package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class AnneeAcademiqueDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long anneeId;
	private int debutAnnee;
	private int finAnnee;
	private String etat;
	private Collection<EmploiDto> emploisDto;
	
	
	public AnneeAcademiqueDto() {
		super();
		emploisDto = new ArrayList<EmploiDto>();
	}
	public AnneeAcademiqueDto(int debutAnnee, int finAnnee, String etat) {
		super();
		this.debutAnnee = debutAnnee;
		this.finAnnee = finAnnee;
		this.etat = etat;
		emploisDto = new ArrayList<EmploiDto>();
	}
	public int getDebutAnnee() {
		return debutAnnee;
	}

	public void setDebutAnnee(int debutAnnee) {
		this.debutAnnee = debutAnnee;
	}

	public int getFinAnnee() {
		return finAnnee;
	}

	public void setFinAnnee(int finAnnee) {
		this.finAnnee = finAnnee;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	public void setEmploisDto(Collection<EmploiDto> emploisDto) {
		this.emploisDto = emploisDto;
	}

	public long getAnneeId() {
		return anneeId;
	}
	
	public void setAnneeId(long anneeId){
		this.anneeId = anneeId;
	}
	public Collection<EmploiDto> getEmploisDto() {
		return emploisDto;
	}
	public void setEmploi(Collection<EmploiDto> emploi) {
		this.emploisDto = emploi;
	}	
	
	
}
