package edu.ipsas.edt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VOEUX_MATIERE")
public class VoeuxMatiere implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long voeuxMatiereId;
	
	@ManyToOne
	@JoinColumn(name="ENSEIGNANT_ID")
	private Enseignant enseignant;
	
	@ManyToOne
	@JoinColumn(name="MATIERE_ID")
	private Matiere matiere;
	
	@Column(name="AFFECTE")
	private boolean affecte;
	
	public VoeuxMatiere() {
		super();
	}
	public VoeuxMatiere(Enseignant enseignant, Matiere matiere, boolean affecte) {
		super();
		this.enseignant = enseignant;
		this.matiere = matiere;
		this.affecte = affecte;
		enseignant.getVoeuxMatieres().add(this);
	}
	public long getVoeuxMatiereId() {
		return voeuxMatiereId;
	}
	public void setVoeuxMatiereId(long voeuxMatiereId) {
		this.voeuxMatiereId = voeuxMatiereId;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public boolean isAffecte() {
		return affecte;
	}
	public void setAffecte(boolean affecte) {
		this.affecte = affecte;
	}
	
	
}

