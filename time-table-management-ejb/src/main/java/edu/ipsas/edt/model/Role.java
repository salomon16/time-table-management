package edu.ipsas.edt.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role  {

	@Id
	@Column(name="ROLE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long roleId;
	
	@Column(name="TYPE", unique = true, nullable = false)
	private String type;
	
	@ManyToMany(mappedBy = "roles")
	private Collection<PersonnelAdministratif> personnelsAdministratif;
	
	public Role() {
		
		personnelsAdministratif = new ArrayList<PersonnelAdministratif>();
	}

	public Role(String type) {
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

	public Collection<PersonnelAdministratif> getPersonnelsAdministratif() {
		return personnelsAdministratif;
	}

	public void setPersonnelsAdministratif(
			Collection<PersonnelAdministratif> personnelsAdministratif) {
		this.personnelsAdministratif = personnelsAdministratif;
	}

	 
}
