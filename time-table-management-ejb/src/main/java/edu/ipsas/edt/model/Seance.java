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
@Table(name="SEANCE")
public class Seance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SEANCE_ID", unique=true, nullable=false)
	private long seanceId;
	
	@Column(name="NUMERO", unique=false, nullable=true)
	private int numero;
	
	@Column(name="JOUR", unique=false, nullable=true)
	private String jour;

	@ManyToOne
	@JoinColumn(name="EMPLOI_ID")
	private Emploi emploi;
	
	@ManyToOne
	@JoinColumn(name="CRENEAU_ID")
	private Creneau creneau;
	
	@ManyToOne
	@JoinColumn(name="MATIERE_ID")
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name="SALLE_ID")
	private Salle salle ;
	
	@ManyToOne
	@JoinColumn(name="ENSEIGNANT_ID")
	private Enseignant enseignant;

	
	public Seance() {
		super();
	}

	public Seance(int numero, String jour, Emploi emploi,
			Creneau creneau, Matiere matiere, Salle salle, Enseignant enseignant) {
		super();
		this.numero = numero;
		this.jour = jour;
		this.emploi = emploi;
		this.creneau = creneau;
		this.matiere = matiere;
		this.salle = salle;
		this.enseignant = enseignant;
	}

	public long getSeanceId() {
		return seanceId;
	}

	public void setSeanceId(long seanceId) {
		this.seanceId = seanceId;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Emploi getEmploi() {
		return emploi;
	}

	public void setEmploi(Emploi emploi) {
		this.emploi = emploi;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	

}
