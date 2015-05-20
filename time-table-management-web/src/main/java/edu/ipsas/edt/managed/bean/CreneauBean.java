package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import edu.ipsas.edt.service.EnseignantService;

@ManagedBean
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
		
		return null;
	}
	
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        if(horaireDebut.equals(horaireFin)){
        	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Veuillez changer l'horaire de fin", format.format(event.getObject())));
        }
        
        if(horaireDebut.getHours() > horaireFin.getHours()){
        	facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Veuillez changer l'horaire de debut", format.format(event.getObject())));
        }
        
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
