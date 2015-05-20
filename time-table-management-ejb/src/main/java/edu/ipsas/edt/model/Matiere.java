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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MATIERE")
public class Matiere implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MATIERE_ID", nullable=false, unique=true)
	private long matiereId;
	
	@Column(name="NOM", nullable=true, unique=false)
	private String nom;

	@Column(name="DESCRIPTION", nullable=true, unique=false)
	private String description;
	
	@Column(name="TYPE", nullable=false, unique=true)
	private String type;

	@Column(name="VOLUME_C", nullable=true, unique=false)
	private float volumeC;
	
	@Column(name="VOLUME_TP", nullable=true, unique=false)
	private float volumeTp;
	
	@Column(name="VOLUME_TD", nullable=true, unique=false)
	private float volumeTd;

	@Column(name="CREDIT", nullable=true, unique=false)
	private float credit;
	
	@Column(name="COEFFICIENT", nullable=true, unique=false)
	private int coefficient;
	
	@ManyToOne
	@JoinColumn(name="UNITE_ID",nullable=false)
	private Unite unite;
	
	@OneToMany
	private Collection<PlanEtude> plansEtude;
	
	public Matiere() {
		super();
		plansEtude = new ArrayList<PlanEtude>();
	}

	public Matiere(String nom, String description, String type, float volumeC,
			float volumeTp, float volumeTd, float credit, int coefficient, Unite unite) {
		super();
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.volumeC = volumeC;
		this.volumeTp = volumeTp;
		this.volumeTd = volumeTd;
		this.credit = credit;
		this.coefficient = coefficient;
		this.unite = unite;
		unite.getMatieres().add(this);
		plansEtude = new ArrayList<PlanEtude>();
	}

	public long getMatiereId() {
		return matiereId;
	}

	public void setMatiereId(long matiereId) {
		this.matiereId = matiereId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getVolumeC() {
		return volumeC;
	}

	public void setVolumeC(float volumeC) {
		this.volumeC = volumeC;
	}

	public float getVolumeTp() {
		return volumeTp;
	}

	public void setVolumeTp(float volumeTp) {
		this.volumeTp = volumeTp;
	}

	public float getVolumeTd() {
		return volumeTd;
	}

	public void setVolumeTd(float volumeTD) {
		this.volumeTd = volumeTD;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public Collection<PlanEtude> getPlansEtude() {
		return plansEtude;
	}

	public void setPlansEtude(Collection<PlanEtude> plansEtude) {
		this.plansEtude = plansEtude;
	}
	
	
}
