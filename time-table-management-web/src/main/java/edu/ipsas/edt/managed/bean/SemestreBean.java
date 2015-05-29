package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.SemestreDto;
import edu.ipsas.edt.service.EmploiDuTempsService;

@ManagedBean(name="semestreBean")
@ViewScoped
public class SemestreBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmploiDuTempsService emploiService;
	SemestreDto semestreDto;
	
	public SemestreBean(){
		semestreDto = new SemestreDto();
	}

	public String save(){
		
		long id = emploiService.addSemestre(semestreDto);
		
		if(id > 0){
			FacesContext fc = FacesContext.getCurrentInstance();  
	        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Semestre ajouté avec succes", null));  
		}
		return null;
	}
	
	public Collection<SemestreDto> getAllSemestre(){
		return emploiService.getAllSemestre();
	}
	
	public Collection<SemestreDto> getAllSemester(){
		return emploiService.getAllSemestre();
	}
	public EmploiDuTempsService getEmploiService() {
		return emploiService;
	}

	public void setEmploiService(EmploiDuTempsService emploiService) {
		this.emploiService = emploiService;
	}

	public SemestreDto getSemestreDto() {
		return semestreDto;
	}

	public void setSemestreDto(SemestreDto semestreDto) {
		this.semestreDto = semestreDto;
	}
	
	

}
