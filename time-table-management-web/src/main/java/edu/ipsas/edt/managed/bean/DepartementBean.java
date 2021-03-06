package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import edu.ipsas.edt.dto.CursusDto;
import edu.ipsas.edt.dto.DepartementDto;
import edu.ipsas.edt.service.DepartementService;

@ManagedBean(name="departementBean")
@ViewScoped
public class DepartementBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private DepartementService departementService;
	private String nom;
	private DepartementDto departementDto = new DepartementDto();
	private DepartementDto selectedDepartement;
	private Collection<CursusDto> cursus;
	
	public String save() {

		DepartementDto departement = new DepartementDto();
		departement.setNom(getNom());

		long id = departementService.addDepartement(departement);

		if (id > 0) {
			FacesContext fc = FacesContext.getCurrentInstance();  
	        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Departement ajouté avec succes", null));  
		}
		
		return null;
	}
	   public void showCursus() {
	        RequestContext.getCurrentInstance().openDialog("departementcursus");
	    }
	   
	   public void onDepartementChosen(SelectEvent event) {
	        selectedDepartement = (DepartementDto) event.getObject();

	    }
	//methode pour recuperer le departement selectionné
		public void selectedDepartement(long selectedDepartementId) {

			setSelectedDepartement(departementService
					.getDepartementByCode(selectedDepartementId));
			System.out.println("Selected Departement iD: "
					+ selectedDepartement.getDepartementID());
		}

		//methode pour la mise a jour d'un enseignant
		public void update() {

//			if (!statut.equals(selectedEnseignant.getStatutDto().getNom()))
//				getSelectedEnseignant().setStatutDto(
//						enseignantService.getStatutByName(getStatut()));
//
//			if (!grade.equals(selectedEnseignant.getGradeDto().getNom()))
//				getSelectedEnseignant().setGradeDto(
//						enseignantService.getGradeByName(getGrade()));
//
//			enseignantService.updateEnseignant(selectedEnseignant);
//
//			FacesContext context = FacesContext.getCurrentInstance();
//			context.addMessage(null, new FacesMessage("Enseignant mise à jour"));

		}
		//methode pour la suppression d'un enseignant
		public void delete() {
			
//			getEnseignantService().deleteEnseignant(selectedEnseignant);
			
		}
		
	public Collection<CursusDto> getAllCursus(){
		
		if(selectedDepartement==null)
			return null;
		
		return departementService.getAllCursusByDepartement(selectedDepartement.getDepartementID());
		
	}
	public Collection<DepartementDto> getAllDepartement() {

		return departementService.getAllDepartement();
	}

	public DepartementService getDepartementService() {
		return departementService;
	}
	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public DepartementDto getDepartementDto() {
		return departementDto;
	}

	public void setDepartementDto(DepartementDto departementDto) {
		this.departementDto = departementDto;
	}

	public Collection<CursusDto> getCursus() {
		return cursus;
	}

	public void setCursus(Collection<CursusDto> specialites) {
		this.cursus = specialites;
	}

	public DepartementDto getSelectedDepartement() {
		return selectedDepartement;
	}

	public void setSelectedDepartement(DepartementDto selectedDepartement) {
		this.selectedDepartement = selectedDepartement;
	}

	
	
}
