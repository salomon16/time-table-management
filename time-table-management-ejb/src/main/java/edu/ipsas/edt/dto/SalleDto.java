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
	
	private Collection<RessourceDto> ressourcesDto;

	private String typeSalle;
	
	private DepartementDto departementDto;

	public SalleDto() {
		super();
		ressourcesDto = new ArrayList<RessourceDto>();
	}

	public SalleDto(String numero, String typeSalleDto) {
		super();
		this.numero = numero;
		this.typeSalle = typeSalleDto;
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

	public Collection<RessourceDto> getRessourcesDto() {
		return ressourcesDto;
	}

	public void setRessourcesDto(Collection<RessourceDto> ressources) {
		this.ressourcesDto = ressources;
	}

	public String getTypeSalle() {
		return typeSalle;
	}

	public void setTypeSalle(String typeSalle) {
		this.typeSalle = typeSalle;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public DepartementDto getDepartementDto() {
		return departementDto;
	}

	public void setDepartementDto(DepartementDto departementDto) {
		this.departementDto = departementDto;
	}

	
}
