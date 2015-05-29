package edu.ipsas.edt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ANNEE_ACADEMIQUE")
public class AnneeAcademique implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ANNEE_ID", unique=true, nullable=false)
	private long anneeId;
	
	@Column(name="DEBUT_ANNEE", unique=true, nullable=false)
	private int debutAnnee;
	
	@Column(name="FIN_ANNEE", unique=true, nullable=false)
	private int finAnnee;
	
	@Column(name="ETAT", unique=false, nullable=true)
	private String etat;
	
	@OneToMany
	private Collection<Emploi> emploi;

	
	public AnneeAcademique() {
		super();
		emploi = new ArrayList<Emploi>();
	}

	public AnneeAcademique(int debutAnnee, int finAnnee, String etat) {
		super();
		this.debutAnnee = debutAnnee;
		this.finAnnee = finAnnee;
		this.etat = etat;
		emploi = new ArrayList<Emploi>();
	}

	public long getAnneeId() {
		return anneeId;
	}

	public void setAnneeId(long anneeId) {
		this.anneeId = anneeId;
	}

	public int getDebutAnnee() {
		return debutAnnee;
	}


	public void setDebutAnnee(int debutAnnee) {
		this.debutAnnee = debutAnnee;
	}


	public int getFinAnnee() {
		return finAnnee;
	}


	public void setFinAnnee(int finAnnee) {
		this.finAnnee = finAnnee;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public Collection<Emploi> getEmploi() {
		return emploi;
	}

	public void setEmploi(Collection<Emploi> emploi) {
		this.emploi = emploi;
	}
	
	

}
