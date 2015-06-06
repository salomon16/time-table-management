package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.CreneauDto;
import edu.ipsas.edt.service.EmploiDuTempsService;

@ManagedBean(name="creneauBean")
@ViewScoped
public class CreneauBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	EmploiDuTempsService emploiService;
	
	private int ordre;
	private String libelle;
	
	
	public String save(){
		
		CreneauDto creneauDto = new CreneauDto();
		creneauDto.setLibelle(libelle);
		creneauDto.setOrdre(ordre);
		
		long id = emploiService.addCreneau(creneauDto);
		
		if(id > 0){
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nouvel horaire ajouté avec succes", null));  
		}
		else{
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Echec de creation", null));  
		}
		
		return null;
	}
	
	public Collection<CreneauDto> getAllCreneau(){
		return emploiService.getAllCreneau();
	}
	public EmploiDuTempsService getEmploiService() {
		return emploiService;
	}


	public void setEmploiService(EmploiDuTempsService emploiService) {
		this.emploiService = emploiService;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
}
