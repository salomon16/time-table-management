package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import edu.ipsas.edt.dto.CursusDto;
import edu.ipsas.edt.dto.DepartementDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.service.DepartementService;

@ManagedBean(name="parcoursBean")
@ViewScoped
public class ParcoursBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private DepartementService departementService;
	private String nom;
	private long cursus;
	private String abbreviation;
	private Collection<CursusDto> cursusListe;
	private String selectedDepartement;
	
	
	
	public void save(){
		
		ParcoursDto parcoursDto = new ParcoursDto();
			parcoursDto.setNom(getNom());
			parcoursDto.setAbbreviation(getAbbreviation());
		CursusDto cursusDto = departementService.getCursusById(cursus);
		parcoursDto.setCursusDto(cursusDto);
		
		long id = departementService.addParcours(parcoursDto);
		
		if(id > 0){
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nouveau parcours ajouté avec succes", null));  
		}
	}
	
	public Collection<CursusDto> getAllCursus(){
		
		if(selectedDepartement==null)
			return null;
		
		DepartementDto departement = departementService.getDepartementByName(selectedDepartement);
		
		
		return departementService.getAllCursusByDepartement(departement.getDepartementID());
	}
	
	public Collection<ParcoursDto> getAllParcours(){
		return departementService.getAllParcours();
	}
	
	public void update(){
		
	}
	
	public void delete(){
		
	}
	
	 public void onDepartementChange() {
	        if(selectedDepartement !=null && !selectedDepartement.equals("")){
	    		DepartementDto departement = departementService.getDepartementByName(selectedDepartement);
	    		cursusListe = departementService.getAllCursusByDepartement(departement.getDepartementID());
	        }
	        else
	        	cursusListe = new ArrayList<CursusDto>();
	    }
	 public void stateChangeListener(ValueChangeEvent event) {
	        if (event.getNewValue() != selectedDepartement) {
	        	selectedDepartement = null;
	        }
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

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	
}
