package edu.ipsas.edt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PERSONNEL_ADMINISTRATIF")
public class PersonnelAdministratif extends Personne implements Serializable {
	
	@Id
	@Column(name="PERSONNEL_ADMINISTRATIF_ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long personnelId;
	
	@Column(name="FONCTION", unique = true, nullable = false)
	private String fonction;
	
	@Column(name="TELEPHONE_FIXE", unique = false, nullable = true)
	private String telFixe;
	
	@ManyToMany
	@JoinTable(name="PERSONNEL_ROLES",joinColumns = @JoinColumn( name="PERSONNEL_ADMINISTRATIF_ID", referencedColumnName="PERSONNEL_ADMINISTRATIF_ID"), inverseJoinColumns = @JoinColumn( name="ROLE_ID", referencedColumnName="ROLE_ID"))
	private Collection<Role> roles;

	@ManyToOne
	@JoinColumn(name="DEPARTEMENT_ID")
	private Departement departement;
	
	public PersonnelAdministratif() {
		super();
		roles = new ArrayList<Role>();
	}

	public PersonnelAdministratif(String fonction, String telFixe) {
		super();
		this.fonction = fonction;
		this.telFixe = telFixe;
	}
	
	
	public PersonnelAdministratif(String nom, String prenom, String cin,
			String adresse, String telephoneMobile, String email) {
		super(nom, prenom, cin, adresse, telephoneMobile, email);
		
	}

	public PersonnelAdministratif(String nom, String prenom, String cin,
			String adresse, String telephoneMobile, String email,
			String fonction, String telFixe) {
		super(nom, prenom, cin, adresse, telephoneMobile, email);
		this.fonction = fonction;
		this.telFixe = telFixe;
	}

	public long getPersonnelId() {
		return personnelId;
	}

	
	public void setPersonnelId(long personnelId) {
		this.personnelId = personnelId;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	

}
