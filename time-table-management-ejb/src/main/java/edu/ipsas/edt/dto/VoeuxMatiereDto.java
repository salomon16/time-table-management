package edu.ipsas.edt.dto;

import java.io.Serializable;

public class VoeuxMatiereDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long voeuxMatiereId;
	
	private boolean affecte;
	
	private EnseignantDto enseignantDto;
	
	private MatiereDto matiereDto;

	
	public VoeuxMatiereDto() {
		super();
	}

	public VoeuxMatiereDto(EnseignantDto enseignantDto, MatiereDto matiereDto, boolean affecte) {
		super();
		this.enseignantDto = enseignantDto;
		this.matiereDto = matiereDto;
		this.affecte = affecte;
	}

	public long getVoeuxMatiereId() {
		return voeuxMatiereId;
	}

	public void setVoeuxMatiereId(long voeuxMatiereId) {
		this.voeuxMatiereId = voeuxMatiereId;
	}

	public EnseignantDto getEnseignantDto() {
		return enseignantDto;
	}

	public void setEnseignantDto(EnseignantDto enseignantDto) {
		this.enseignantDto = enseignantDto;
	}

	public MatiereDto getMatiereDto() {
		return matiereDto;
	}

	public void setMatiereDto(MatiereDto matiereDto) {
		this.matiereDto = matiereDto;
	}

	public boolean isAffecte() {
		return affecte;
	}

	public void setAffecte(boolean affecte) {
		this.affecte = affecte;
	}
	
	
	
}
