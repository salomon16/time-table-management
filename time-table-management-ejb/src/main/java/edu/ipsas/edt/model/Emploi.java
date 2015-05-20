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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOI")
public class Emploi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPLOI_ID",unique=true, nullable=false)
	private long emploiId;
	
	@Column(name="NOM",unique=false, nullable=true)
	private int nom;
	
	@Column(name="DATE_DEBUT",unique=false, nullable=false)
	private Date dateDebut;

	@Column(name="DATE_FIN",unique=false, nullable=false)
	private Date dateFin;

	private Date HoraireDebut;

	private Date HoraireFin;
	@ManyToOne
	@JoinColumn(name="ANNEE_ID")
	private AnneeAcademique anneeAcademique;
	
//	@ManyToOne
//	@JoinColumn(name="SEMESTRE_ID")
//	private Semestre semestre;

	@OneToMany
	private Collection<Seance> seance;
	
	@ManyToOne
	@JoinColumn(name="GROUPE_ID")
	private Groupe groupe;

	
	public Emploi() {
		super();
		seance = new ArrayList<Seance>();
	}

	public Emploi(int nom, Date dateDebut, Date dateFin, Date heureMin, Date heureMax, AnneeAcademique anneeAcademique, Collection<Seance> seance, Groupe groupe) {
		super();
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		HoraireDebut = heureMin;
		HoraireFin = heureMax;
		this.anneeAcademique = anneeAcademique;
		this.seance = seance;
		this.groupe = groupe;
		seance = new ArrayList<Seance>();
		groupe.getEmploi().add(this);
		anneeAcademique.getEmploi().add(this);
	
	}

	public long getEmploiId() {
		return emploiId;
	}

	public void setEmploiId(long emploiId) {
		this.emploiId = emploiId;
	}

	public int getNom() {
		return nom;
	}

	public void setNom(int nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Date getHoraireDebut() {
		return HoraireDebut;
	}

	public void setHoraireDebut(Date heureMin) {
		HoraireDebut = heureMin;
	}

	public Date getHoraireFin() {
		return HoraireFin;
	}

	public void setHoraireFin(Date heureMax) {
		HoraireFin = heureMax;
	}

	public AnneeAcademique getAnneeAcademique() {
		return anneeAcademique;
	}

	public void setAnneeAcademique(AnneeAcademique anneeAcademique) {
		this.anneeAcademique = anneeAcademique;
	}

//	public Semestre getSemestre() {
//		return semestre;
//	}
//
//	public void setSemestre(Semestre semestre) {
//		this.semestre = semestre;
//	}

	public Collection<Seance> getSeance() {
		return seance;
	}

	public void setSeance(Collection<Seance> seance) {
		this.seance = seance;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	
	

}
