package edu.ipsas.edt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne implements Serializable {

	@Column(name="NOM", unique = false, nullable = false)
	private String nom;
	
	@Column(name="PRENOM", unique = false, nullable = false)
	private String prenom;

	@Column(name="CIN", unique = true, nullable = false)
	private String cin;

	@Column(name="ADRESSE", unique = false, nullable = false)
	private String adresse;
		
	@Column(name="TELEPHONE_MOBILE", unique = true, nullable = false)
	private String telephoneMobile;
	
	@Column(name="EMAIL", unique = true, nullable = false)
	private String email;

	@Column(name="LOGIN", unique = true, nullable = true)
	private String login;

	@Column(name="PASSWORD", unique = true, nullable = true)
	private String password;

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, String cin, String adresse,
			String telephoneMobile, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.adresse = adresse;
		this.telephoneMobile = telephoneMobile;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
