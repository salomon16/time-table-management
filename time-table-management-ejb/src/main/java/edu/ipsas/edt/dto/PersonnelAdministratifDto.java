package edu.ipsas.edt.dto;

import java.util.ArrayList;
import java.util.Collection;

public class PersonnelAdministratifDto extends PersonneDto {

	
	private long PersonnelId;
	
	private String fonction;
	
	private String telFixe;
	
	private Collection<RoleDto> roles;
	
	private DepartementDto departementDto;

	public PersonnelAdministratifDto() {
		super();
		roles = new ArrayList<RoleDto>();
	}

	public PersonnelAdministratifDto(String nom, String prenom, String cin,
			String adresse, String telephoneMobile, String email) {
		super(nom, prenom, cin, adresse, telephoneMobile, email);
		roles = new ArrayList<RoleDto>();
	}

	public PersonnelAdministratifDto(String fonction, String telFixe) {
		super();
		this.fonction = fonction;
		this.telFixe = telFixe;
		roles = new ArrayList<RoleDto>();
	}

	public PersonnelAdministratifDto(String fonction, String telFixe,
			Collection<RoleDto> roles) {
		super();
		this.fonction = fonction;
		this.telFixe = telFixe;
		this.roles = roles;
		roles = new ArrayList<RoleDto>();
	}

	public PersonnelAdministratifDto(String nom, String prenom, String cin,
			String adresse, String telephoneMobile, String email,
			String fonction, String telFixe) {
		super(nom, prenom, cin, adresse, telephoneMobile, email);
		this.fonction = fonction;
		this.telFixe = telFixe;
		roles = new ArrayList<RoleDto>();
	}

	public long getPersonnelId() {
		return PersonnelId;
	}

	public void setPersonnelId(long personnelId) {
		PersonnelId = personnelId;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getTelFixe() {
		return telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public Collection<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RoleDto> roles) {
		this.roles = roles;
	}

	public DepartementDto getDepartementDto() {
		return departementDto;
	}

	public void setDepartementDto(DepartementDto departementDto) {
		this.departementDto = departementDto;
	}
	
	

}
