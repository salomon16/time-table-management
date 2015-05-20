package edu.ipsas.edt.dto;

import java.util.ArrayList;
import java.util.Collection;


public class EnseignantDto extends PersonneDto {

	private long enseignantId;

	private String specialite;
	
	private Collection<DepartementDto> departements;
	
	private Collection<DisponibiliteDto> disponibilites;
	
	private GradeDto gradeDto;
	
	private StatutDto statutDto;
	
	private Collection<VoeuxMatiereDto> voeuxMatiereDto;

	public EnseignantDto() {
		super();
		departements = new ArrayList<DepartementDto>();
		disponibilites = new ArrayList<DisponibiliteDto>();
		gradeDto = new GradeDto();
		statutDto = new StatutDto();
		voeuxMatiereDto = new ArrayList<VoeuxMatiereDto>();
	}

	public EnseignantDto(String nom, String prenom, String cin, String adresse,
			String telephoneMobile, String email) {
		super(nom, prenom, cin, adresse, telephoneMobile, email);
		departements = new ArrayList<DepartementDto>();
		disponibilites = new ArrayList<DisponibiliteDto>();
		voeuxMatiereDto = new ArrayList<VoeuxMatiereDto>();
	}

	public EnseignantDto(String nom, String prenom, String cin, String adresse,
			String telephoneMobile, String email, StatutDto statutDto) {
		super(nom, prenom, cin, adresse, telephoneMobile, email);
		this.statutDto = statutDto;
		departements = new ArrayList<DepartementDto>();
		disponibilites = new ArrayList<DisponibiliteDto>();
		voeuxMatiereDto = new ArrayList<VoeuxMatiereDto>();
	}

	public long getEnseignantID() {
		return enseignantId;
	}

	public void setEnseignantID(long enseignantID) {
		enseignantId = enseignantID;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Collection<DepartementDto> getDepartements() {
		return departements;
	}

	public void setDepartements(Collection<DepartementDto> departements) {
		this.departements = departements;
	}

	public Collection<DisponibiliteDto> getDisponibilites() {
		return disponibilites;
	}

	public void setDisponibilites(Collection<DisponibiliteDto> disponibilites) {
		this.disponibilites = disponibilites;
	}

	public GradeDto getGradeDto() {
		return gradeDto;
	}

	public void setGradeDto(GradeDto gradeDto) {
		this.gradeDto = gradeDto;
	}

	public StatutDto getStatutDto() {
		return statutDto;
	}

	public void setStatutDto(StatutDto statutDto) {
		this.statutDto = statutDto;
	}

	public long getEnseignantId() {
		return enseignantId;
	}

	public void setEnseignantId(long enseignantId) {
		this.enseignantId = enseignantId;
	}

	public Collection<VoeuxMatiereDto> getVoeuxMatiereDto() {
		return voeuxMatiereDto;
	}

	public void setVoeuxMatiereDto(Collection<VoeuxMatiereDto> voeuxMatiereDto) {
		this.voeuxMatiereDto = voeuxMatiereDto;
	}

}
