package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.CreneauDto;
import edu.ipsas.edt.service.EnseignantService;

@ManagedBean(name="creneauBean")
@ViewScoped
public class CreneauBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	EnseignantService enseignantService;
	
	private Date horaireDebut;
	private Date horaireFin;
	
	
	public String save(){
		
		CreneauDto creneauDto = new CreneauDto();
		creneauDto.setHeureDebut(horaireDebut);
		creneauDto.setHeureFin(horaireFin);
		
		long id = enseignantService.addCreneau(creneauDto);
		
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
	
	public EnseignantService getEnseignantService() {
		return enseignantService;
	}
	public void setEnseignantService(EnseignantService enseignantService) {
		this.enseignantService = enseignantService;
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
	
	
}
