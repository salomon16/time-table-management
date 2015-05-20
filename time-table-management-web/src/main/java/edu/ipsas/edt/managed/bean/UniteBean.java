package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.UniteDto;
import edu.ipsas.edt.service.EmploiDuTempsService;

@ManagedBean(name="uniteBean")
@ViewScoped
public class UniteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private EmploiDuTempsService emploiService;

	private UniteDto uniteDto;
	private String unite;

	public UniteBean() {

		uniteDto = new UniteDto();
	}

	public Collection<UniteDto> getAllUnite() {
		
		return getEmploiService().obtenirLesUnites();

	}
	
	public EmploiDuTempsService getEmploiService() {
		return emploiService;
	}

	public void setEmploiService(EmploiDuTempsService emploiService) {
		this.emploiService = emploiService;
	}

	public UniteDto getUniteDto() {
		return uniteDto;
	}

	public void setUniteDto(UniteDto uniteDto) {
		this.uniteDto = uniteDto;
	}

	public void save() {

		long id = emploiService.addUnite(getUniteDto());
		
		
		if(id > 0){
			FacesContext fc = FacesContext.getCurrentInstance();  
	        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Unité ajouté avec succes", null));  
		}
		
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	
}
