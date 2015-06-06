package edu.ipsas.edt.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role  {


	@Id
	@Column(name="ROLE_ID", unique = true, nullable = false)
	private String nom;
	
	@OneToMany
	@JoinTable(name="ROLE_PERSONNELS_ADMINISTRATIF", 
    joinColumns=@JoinColumn(name="ROLE_ID"),
    inverseJoinColumns=@JoinColumn(name="PERSONNEL_ADMINISTRATIF_ID"))
	private Collection<PersonnelAdministratif> personnelsAdministratif;
	
	public Role() {
		
		personnelsAdministratif = new ArrayList<PersonnelAdministratif>();
	}

	public Role(String type) {
		super();
		this.nom = type;
	}

	public String getType() {
		return nom;
	}

	public void setType(String type) {
		this.nom = type;
	}

	public Collection<PersonnelAdministratif> getPersonnelsAdministratif() {
		return personnelsAdministratif;
	}

	public void setPersonnelsAdministratif(
			Collection<PersonnelAdministratif> personnelsAdministratif) {
		this.personnelsAdministratif = personnelsAdministratif;
	}

	 
}
