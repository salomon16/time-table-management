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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PLAN_ETUDE")
public class PlanEtude implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4605696189580789688L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PLAN_ETUDE_ID", nullable=false, unique=true)
	private long planEtudeId;
	
	@ManyToOne
	@JoinColumn(name="SEMESTRE_ID")
	private Semestre semestre;
	
	@ManyToOne
	@JoinColumn(name="PARCOURS_ID")
	private Parcours parcours;
	
	@OneToMany
	@JoinTable(name="PLAN_ETUDE_MATIERES", 
    joinColumns=@JoinColumn(name="PLAN_ETUDE_ID"),
    inverseJoinColumns=@JoinColumn(name="MATIERE_ID"))
	private Collection<Matiere> matieres;
	
	public PlanEtude() {
		matieres = new ArrayList<Matiere>();
	}

	public PlanEtude(Semestre semestre, Parcours parcours) {
		super();
		this.semestre = semestre;
		this.parcours = parcours;
		parcours.getPlansEtude().add(this);
		semestre.getPlansEtude().add(this);
		matieres = new ArrayList<Matiere>();
	}


	public long getPlanEtudeId() {
		return planEtudeId;
	}

	public void setPlanEtudeId(long planEtudeId) {
		this.planEtudeId = planEtudeId;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Parcours getParcours() {
		return parcours;
	}

	public void setParcours(Parcours parcours) {
		this.parcours = parcours;
	}

	public Collection<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Collection<Matiere> matieres) {
		this.matieres = matieres;
	}
	
	
}
