package edu.ipsas.edt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
	
	@Column(name="ANNEE_COURANTE", unique=true, nullable=false)
	private Date anneeCourante;
	
	@Column(name="ETAT", unique=false, nullable=true)
	private String etat;
	
	@OneToMany
	private Collection<Emploi> emploi;

	
	public AnneeAcademique() {
		super();
		emploi = new ArrayList<Emploi>();
	}

	
	public AnneeAcademique(Date currentYear, Collection<Emploi> emploi) {
		super();
		this.anneeCourante = currentYear;
		this.emploi = emploi;
	}


	public long getAnneeId() {
		return anneeId;
	}

	public void setAnneeId(long anneeId) {
		this.anneeId = anneeId;
	}

	public Date getAnneeCourante() {
		return anneeCourante;
	}

	public void setAnneeCourante(Date currentYear) {
		this.anneeCourante = currentYear;
	}

	public Collection<Emploi> getEmploi() {
		return emploi;
	}

	public void setEmploi(Collection<Emploi> emploi) {
		this.emploi = emploi;
	}
	
	

}
