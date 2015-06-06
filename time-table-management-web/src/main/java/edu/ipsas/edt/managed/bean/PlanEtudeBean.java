package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.DepartementDto;
import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.dto.PlanEtudeDto;
import edu.ipsas.edt.dto.UniteDto;
import edu.ipsas.edt.service.DepartementService;
import edu.ipsas.edt.service.EmploiDuTempsService;

@ManagedBean(name="planEtudeBean")
@ViewScoped
public class PlanEtudeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private EmploiDuTempsService emploiService;
	@EJB
	private DepartementService departementService;
	
	private String selectedParcours;
	private String selectedSemestre;
	private String selectedDepartement;
	private Collection<ParcoursDto> listeParcours;
	private Collection<String> selectedMatiere;
	private Collection<MatiereDto> matieres;
	private PlanEtudeDto planEtudeDto;
	
	@PostConstruct
	public void init(){
		matieres = departementService.getAllMatiere();
	}
	
	public String save(){
		
		PlanEtudeDto planEtude = new PlanEtudeDto();
		Collection<MatiereDto> matieres = new ArrayList<MatiereDto>();
		
		for(String matiere : selectedMatiere){
			matieres.add(departementService.getMatiereParId(Long.parseLong(matiere)));
		}
		
		planEtude.setSemestreDto(departementService.getSemestreParId(Long.parseLong(selectedSemestre)));
		planEtude.setParcoursDto(departementService.getParcoursParId(Long.parseLong(selectedParcours)));
		planEtude.setMatieresDto(matieres);
		
		long id = departementService.addPlanEtude(planEtude);
		
		if(id > 0){
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nouveau plan d'etude ajouté avec succes", null));
		}
		return null;
	}
	
	public void findPlanEtude(){
		planEtudeDto = departementService.getPlanEtudeBySemestreAndParcours(departementService.getSemestreParId(Long.parseLong(selectedSemestre)).getSemestreId(), departementService.getParcoursParId(Long.parseLong(selectedParcours)).getParcoursId());
	}
	public Collection<UniteDto> getAllUnite(){
		Collection<UniteDto> unites = new ArrayList<UniteDto>();
		boolean exist = false;
		for(MatiereDto matiere : planEtudeDto.getMatieresDto()){
			 UniteDto unite = matiere.getUniteDto();
			 
			 for(UniteDto currentUnite : unites){
				 if(currentUnite.equals(unite)){
					 exist = true;
					 break;
				 }
					 
			 }
			 if(!exist){
				 unites.add(unite);
			 }
		}
		return unites;
	}
	
	 public void onDepartementChange() {
	        if(selectedDepartement !=null && !selectedDepartement.equals("")){
	    		DepartementDto departement = departementService.getDepartementByName(selectedDepartement);
	    		listeParcours = (Collection<ParcoursDto>) departementService.getAllParcoursByDepartement(departement.getDepartementID());
	        }
	        else
	        	listeParcours = new ArrayList<ParcoursDto>();
	    }
	public EmploiDuTempsService getEmploiService() {
		return emploiService;
	}
	public void setEmploiService(EmploiDuTempsService emploiservice) {
		this.emploiService = emploiservice;
	}
	public String getSelectedParcours() {
		return selectedParcours;
	}
	public void setSelectedParcours(String selectedParcours) {
		this.selectedParcours = selectedParcours;
	}
	public String getSelectedSemestre() {
		return selectedSemestre;
	}
	public void setSelectedSemestre(String selectedSemestre) {
		this.selectedSemestre = selectedSemestre;
	}
	
	public Collection<String> getSelectedMatiere() {
		return selectedMatiere;
	}
	public void setSelectedMatiere(Collection<String> selectedMatiere) {
		this.selectedMatiere = selectedMatiere;
	}
	public Collection<MatiereDto> getMatieres() {
		return matieres;
	}
	public void setMatieres(Collection<MatiereDto> matieres) {
		this.matieres = matieres;
	}
	
	public String getSelectedDepartement() {
		return selectedDepartement;
	}
	public void setSelectedDepartement(String selectedDepartement) {
		this.selectedDepartement = selectedDepartement;
	}

	
	public DepartementService getDepartementService() {
		return departementService;
	}

	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}

	public Collection<ParcoursDto> getListeParcours() {
		return listeParcours;
	}

	public void setListeParcours(Collection<ParcoursDto> listeParcours) {
		this.listeParcours = listeParcours;
	}

	public PlanEtudeDto getPlanEtudeDto() {
		return planEtudeDto;
	}

	public void setPlanEtudeDto(PlanEtudeDto planEtudeDto) {
		this.planEtudeDto = planEtudeDto;
	}
	
}
