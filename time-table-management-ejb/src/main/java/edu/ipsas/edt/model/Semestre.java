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
@Table(name="SEMESTRE")
public class Semestre implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="SEMESTRE_ID", nullable=false, unique=true)
	private long semestreId;
	
	@Column(name="NUMERO", nullable=false, unique=true)
	private byte numero;

	@OneToMany
	private Collection<PlanEtude> plansEtude;
	
//	@OneToMany
//	private Collection<Emploi> emplois;

	public Semestre() {
		super();
		plansEtude = new ArrayList<PlanEtude>();
	}

	public Semestre(byte numero, Collection<PlanEtude> plansEtude) {
		super();
		this.numero = numero;
		this.plansEtude = plansEtude;
	}

	public byte getNumero() {
		return numero;
	}

	public void setNumero(byte numero) {
		this.numero = numero;
	}

	public Collection<PlanEtude> getPlansEtude() {
		return plansEtude;
	}

	public void setPlansEtude(Collection<PlanEtude> plansEtude) {
		this.plansEtude = plansEtude;
	}

	public long getSemestreId() {
		return semestreId;
	}

	public void setSemestreId(long semestreId) {
		this.semestreId = semestreId;
	}

}
