package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.SemestreDto;
import edu.ipsas.edt.service.DepartementService;

@ManagedBean(name="semestreBean")
@ViewScoped
public class SemestreBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DepartementService departementService;
	SemestreDto semestreDto;
	
	public SemestreBean(){
		semestreDto = new SemestreDto();
	}

	public String save(){
		
		long id = departementService.addSemestre(semestreDto);
		
		if(id > 0){
			FacesContext fc = FacesContext.getCurrentInstance();  
	        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Semestre ajouté avec succes", null));  
		}
		return null;
	}
	
	public Collection<SemestreDto> getAllSemestre(){
		return departementService.getAllSemestre();
	}
	
	public Collection<SemestreDto> getAllSemester(){
		return departementService.getAllSemestre();
	}
	
	public DepartementService getDepartementService() {
		return departementService;
	}

	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}

	public SemestreDto getSemestreDto() {
		return semestreDto;
	}

	public void setSemestreDto(SemestreDto semestreDto) {
		this.semestreDto = semestreDto;
	}
	
	

}
