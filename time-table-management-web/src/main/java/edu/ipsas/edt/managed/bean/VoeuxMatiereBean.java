package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.ipsas.edt.dto.CursusDto;
import edu.ipsas.edt.dto.EnseignantDto;
import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.dto.PlanEtudeDto;
import edu.ipsas.edt.service.EmploiDuTempsService;
import edu.ipsas.edt.service.EnseignantService;

@ManagedBean(name="voeuxBean")
@ViewScoped
public class VoeuxMatiereBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private EnseignantService enseignantService;
	@EJB
	private EmploiDuTempsService emploiService;
	private long selectedDepartement;
	private Collection<EnseignantDto> enseignantListe;
	private Collection<CursusDto> cursusListe;
	private Collection<ParcoursDto> parcoursListe;
	private Collection<PlanEtudeDto> planEtudeListe;
	private Collection<MatiereDto> matiereListe;
	private long enseignant;
	private long cursus;
	private long parcours;
	private long planEtude;
	public void save(){
		
	}
	
	public void onDepartementChange() {
        if(selectedDepartement != 0){
    	
    		enseignantListe = enseignantService.getAllEnseignant(selectedDepartement);
    		cursusListe = enseignantService.getAllCursusByDepartement(selectedDepartement);
        }
        else{
        	enseignantListe = new ArrayList<EnseignantDto>();
        	cursusListe = new ArrayList<CursusDto>();
        }
    }
	
	public void onCursusChange() {
        if(cursus != 0){
    		CursusDto cursusDto = enseignantService.getCursusById(cursus);
    		parcoursListe = enseignantService.getAllParcoursByCursus(cursusDto.getCursusId());
    		
        }
        else{
        	parcoursListe = new ArrayList<ParcoursDto>();
        }
    }
	
	public void onParcoursChange() {
        if(cursus != 0){
    		ParcoursDto parcoursDto = emploiService.getParcoursParId(parcours);
    		planEtudeListe = emploiService.getAllPlanEtudeByParcours(parcoursDto.getParcoursId());
    		
        }
        else{
    		planEtudeListe = new ArrayList<PlanEtudeDto>();
        }
    }
	
	public void onPlanEtudeChange() {
        if(planEtude != 0){
    		matiereListe = emploiService.getAllMatiereByPlanEtude(planEtude);
    		
        }
        else{
    		matiereListe = new ArrayList<MatiereDto>();
        }
    }

	public EnseignantService getEnseignantService() {
		return enseignantService;
	}

	public void setEnseignantService(EnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}

	public long getSelectedDepartement() {
		return selectedDepartement;
	}

	public void setSelectedDepartement(long selectedDepartement) {
		this.selectedDepartement = selectedDepartement;
	}

	public Collection<EnseignantDto> getEnseignantListe() {
		return enseignantListe;
	}

	public void setEnseignantListe(Collection<EnseignantDto> enseignantListe) {
		this.enseignantListe = enseignantListe;
	}

	public long getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(long enseignant) {
		this.enseignant = enseignant;
	}

	public Collection<CursusDto> getCursusListe() {
		return cursusListe;
	}

	public void setCursusListe(Collection<CursusDto> cursusListe) {
		this.cursusListe = cursusListe;
	}

	public Collection<ParcoursDto> getParcoursListe() {
		return parcoursListe;
	}

	public void setParcoursListe(Collection<ParcoursDto> parcoursListe) {
		this.parcoursListe = parcoursListe;
	}

	public long getCursus() {
		return cursus;
	}

	public void setCursus(long cursus) {
		this.cursus = cursus;
	}

	public long getParcours() {
		return parcours;
	}

	public void setParcours(long parcours) {
		this.parcours = parcours;
	}

	public EmploiDuTempsService getEmploiService() {
		return emploiService;
	}

	public void setEmploiService(EmploiDuTempsService emploiService) {
		this.emploiService = emploiService;
	}

	public Collection<PlanEtudeDto> getPlanEtudeListe() {
		return planEtudeListe;
	}

	public void setPlanEtudeListe(Collection<PlanEtudeDto> planEtudeListe) {
		this.planEtudeListe = planEtudeListe;
	}

	public Collection<MatiereDto> getMatiereListe() {
		return matiereListe;
	}

	public void setMatiereListe(Collection<MatiereDto> matiereListe) {
		this.matiereListe = matiereListe;
	}

	public long getPlanEtude() {
		return planEtude;
	}

	public void setPlanEtude(long planEtude) {
		this.planEtude = planEtude;
	}
	
}
