package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class SalleDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long salleId;

	private String numero;
	
	private int capacite;
	
	private EtablissementDto etablissementDto;
	
	private Collection<RessourceDto> ressourcesDto;

	private TypeSalleDto typeSalleDto;

	public SalleDto() {
		super();
		ressourcesDto = new ArrayList<RessourceDto>();
	}

	public SalleDto(String numero, EtablissementDto etablissementDto, TypeSalleDto typeSalleDto) {
		super();
		this.numero = numero;
		this.etablissementDto = etablissementDto;
		this.typeSalleDto = typeSalleDto;
		ressourcesDto = new ArrayList<RessourceDto>();
	}

	public long getSalleId() {
		return salleId;
	}

	public void setSalleId(long salleId) {
		this.salleId = salleId;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public EtablissementDto getEtablissementDto() {
		return etablissementDto;
	}

	public void setEtablissementDto(EtablissementDto etablissementDto) {
		this.etablissementDto = etablissementDto;
	}

	public Collection<RessourceDto> getRessourcesDto() {
		return ressourcesDto;
	}

	public void setRessourcesDto(Collection<RessourceDto> ressources) {
		this.ressourcesDto = ressources;
	}

	public TypeSalleDto getTypeSalleDto() {
		return typeSalleDto;
	}

	public void setTypeSalleDto(TypeSalleDto typeSalleDto) {
		this.typeSalleDto = typeSalleDto;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	
}
