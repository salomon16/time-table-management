package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class AnneeAcademiqueDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long anneeId;
	private Date currentYear;
	private Collection<EmploiDto> emploisDto;
	
	
	public AnneeAcademiqueDto() {
		super();
	}

	public AnneeAcademiqueDto(Date currentYear, Collection<EmploiDto> emploi) {
		super();
		this.currentYear = currentYear;
		this.emploisDto = emploi;
	}
	
	public long getAnneeId() {
		return anneeId;
	}
	public void setAnneeId(long anneeId) {
		this.anneeId = anneeId;
	}
	public Date getAnneeCourante() {
		return currentYear;
	}
	public void setAnneeCourante(Date currentYear) {
		this.currentYear = currentYear;
	}
	public Collection<EmploiDto> getEmploisDto() {
		return emploisDto;
	}
	public void setEmploi(Collection<EmploiDto> emploi) {
		this.emploisDto = emploi;
	}	
	
	
}
