package edu.ipsas.edt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class EmploiDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long emploiId;
	private int nom;
	private Date dateDebut;
	private Date dateFin;
	private Date horaireDebut;
	private Date horaireFin;
	private AnneeAcademiqueDto anneeAcademiqueDto;
//	private SemestreDto semestreDto;
	private Collection<SeanceDto> seanceDto;
	private GroupeDto groupeDto;
	
	
	public EmploiDto() {
		super();
		seanceDto = new ArrayList<SeanceDto>();
	}
	
	
	public EmploiDto(long emploiId, int nom, Date dateDebut, Date dateFin,
			Date horaireDebut, Date horaireFin, AnneeAcademiqueDto anneeAcademique,
			Collection<SeanceDto> seance, GroupeDto groupe) {
		super();
		this.emploiId = emploiId;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.horaireDebut = horaireDebut;
		this.horaireFin = horaireFin;
		this.anneeAcademiqueDto = anneeAcademique;
		this.seanceDto = seance;
		this.groupeDto = groupe;
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
		return horaireDebut;
	}
	public void setHoraireDebut(Date horaireDebut) {
		this.horaireDebut = horaireDebut;
	}
	public Date getHoraireFin() {
		return horaireFin;
	}
	public void setHoraireFin(Date horaireFin) {
		this.horaireFin = horaireFin;
	}
	public AnneeAcademiqueDto getAnneeAcademiqueDto() {
		return anneeAcademiqueDto;
	}
	public void setAnneeAcademiqueDto(AnneeAcademiqueDto anneeAcademiqueDto) {
		this.anneeAcademiqueDto = anneeAcademiqueDto;
	}

//	public SemestreDto getSemestreDto() {
//		return semestreDto;
//	}
//
//
//	public void setSemestreDto(SemestreDto semestreDto) {
//		this.semestreDto = semestreDto;
//	}


	public Collection<SeanceDto> getSeanceDto() {
		return seanceDto;
	}


	public void setSeanceDto(Collection<SeanceDto> seanceDto) {
		this.seanceDto = seanceDto;
	}


	public GroupeDto getGroupeDto() {
		return groupeDto;
	}
	public void setGroupeDto(GroupeDto groupe) {
		this.groupeDto = groupe;
	}
	
	

}
