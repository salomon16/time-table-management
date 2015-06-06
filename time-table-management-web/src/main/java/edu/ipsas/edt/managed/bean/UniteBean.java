package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.UniteDto;
import edu.ipsas.edt.service.DepartementService;

@ManagedBean(name="uniteBean")
@ViewScoped
public class UniteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private DepartementService departementService;

	private UniteDto uniteDto;
	private String unite;

	public UniteBean() {

		uniteDto = new UniteDto();
	}

	public void save() {

		long id = departementService.addUnite(getUniteDto());
		
		
		if(id > 0){
			FacesContext fc = FacesContext.getCurrentInstance();  
	        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Unité ajouté avec succes", null));  
		}
		
	}

	public Collection<UniteDto> getAllUnite() {
		
		return departementService.getAllUnite();

	}
	
	public UniteDto getUniteDto() {
		return uniteDto;
	}

	public void setUniteDto(UniteDto uniteDto) {
		this.uniteDto = uniteDto;
	}
	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public DepartementService getDepartementService() {
		return departementService;
	}

	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}

	
}
