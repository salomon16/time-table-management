package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class SemestreDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long semestreId;
	
	private byte numero;

	private Collection<PlanEtudeDto> plansEtudeDto;
	
	public SemestreDto() {
		super();
		plansEtudeDto = new ArrayList<PlanEtudeDto>();
	}

	public SemestreDto(byte numero, Collection<PlanEtudeDto> plansEtudeDto) {
		super();
		this.numero = numero;
		this.plansEtudeDto = plansEtudeDto;
	}

	public long getSemestreId() {
		return semestreId;
	}

	public void setSemestreId(long semestreId) {
		this.semestreId = semestreId;
	}

	public byte getNumero() {
		return numero;
	}

	public void setNumero(byte numero) {
		this.numero = numero;
	}

	public Collection<PlanEtudeDto> getPlansEtudeDto() {
		return plansEtudeDto;
	}

	public void setPlansEtudeDto(Collection<PlanEtudeDto> plansEtudeDto) {
		this.plansEtudeDto = plansEtudeDto;
	}

}
