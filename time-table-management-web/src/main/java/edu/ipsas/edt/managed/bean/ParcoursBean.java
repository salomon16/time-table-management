package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.context.RequestContext;

import edu.ipsas.edt.dto.CursusDto;
import edu.ipsas.edt.dto.DepartementDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.service.EnseignantService;

@ManagedBean
@SessionScoped
public class ParcoursBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private EnseignantService enseignantService;
	private String nom;
	private long cursus;
	private Collection<CursusDto> cursusListe;
	private String selectedDepartement;
	
	
	
	public void save(){
		
		ParcoursDto parcoursDto = new ParcoursDto();
			parcoursDto.setNom(getNom());
		CursusDto cursusDto = getEnseignantService().getCursusById(cursus);
		parcoursDto.setCursusDto(cursusDto);
		
		long id = getEnseignantService().addParcours(parcoursDto);
		
		if(id > 0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Enregistrement","Succes");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	}
	
	public Collection<CursusDto> getAllCursus(){
		
		if(selectedDepartement==null)
			return null;
		
		DepartementDto departement = enseignantService.getDepartementByName(selectedDepartement);
		
		
		return enseignantService.getAllCursusByDepartement(departement.getDepartementID());
	}
	
	public Collection<ParcoursDto> getAllParcours(){
		return enseignantService.getAllParcours();
	}
	
	public void update(){
		
	}
	
	public void delete(){
		
	}
	
	 public void onDepartementChange() {
	        if(selectedDepartement !=null && !selectedDepartement.equals("")){
	    		DepartementDto departement = enseignantService.getDepartementByName(selectedDepartement);
	    		cursusListe = enseignantService.getAllCursusByDepartement(departement.getDepartementID());
	        }
	        else
	        	cursusListe = new ArrayList<CursusDto>();
	    }
	 public void stateChangeListener(ValueChangeEvent event) {
	        if (event.getNewValue() != selectedDepartement) {
	        	selectedDepartement = null;
	        }
	    }
	 
	public EnseignantService getEnseignantService() {
		return enseignantService;
	}
	public void setEnseignantService(EnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public long getCursus() {
		return cursus;
	}

	public void setCursus(long cursus) {
		this.cursus = cursus;
	}

	public String getSelectedDepartement() {
		return selectedDepartement;
	}

	public void setSelectedDepartement(String selectedDepartement) {
		this.selectedDepartement = selectedDepartement;
	}

	public Collection<CursusDto> getCursusListe() {
		return cursusListe;
	}

	public void setCursusListe(Collection<CursusDto> cursusListe) {
		this.cursusListe = cursusListe;
	}
	
	
}
