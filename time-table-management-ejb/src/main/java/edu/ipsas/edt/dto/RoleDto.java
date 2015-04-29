package edu.ipsas.edt.dto;

import java.util.ArrayList;
import java.util.Collection;

public class RoleDto {

	private long roleId;

	private String type;

	private Collection<PersonnelAdministratifDto> personnelsAdministratif;

	
	public RoleDto() {
		super();
		personnelsAdministratif = new ArrayList<PersonnelAdministratifDto>();
	}

	public RoleDto(String type) {
		super();
		this.type = type;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<PersonnelAdministratifDto> getPersonnelsAdministratif() {
		return personnelsAdministratif;
	}

	public void setPersonnelsAdministratif(
			Collection<PersonnelAdministratifDto> personnelsAdministratif) {
		this.personnelsAdministratif = personnelsAdministratif;
	}
	
	

}
