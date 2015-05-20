package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import edu.ipsas.edt.dto.StatutDto;
import edu.ipsas.edt.service.EnseignantService;

@ManagedBean(name="statutBean")
@ViewScoped
public class StatutBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private EnseignantService enseignantService;

	private StatutDto statutDto;
	private Collection<StatutDto> statutsDto;

	public StatutBean() {

		statutDto = new StatutDto();
	}

	public Collection<StatutDto> getAllStatut() {

		statutsDto = getEnseignantService().getAllStatut();

		return statutsDto;

	}

	public EnseignantService getEnseignantService() {
		return enseignantService;
	}

	public void setEnseignantService(EnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}

	public StatutDto getStatutDto() {
		return statutDto;
	}

	public void setStatutDto(StatutDto statutDto) {
		this.statutDto = statutDto;
	}

	public Collection<StatutDto> getStatutsDto() {
		return statutsDto;
	}

	public void setStatutsDto(Collection<StatutDto> statutsDto) {
		this.statutsDto = statutsDto;
	}

	public void save() {

		long id = enseignantService.addStatut(getStatutDto());
		
		
		if(id > 0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Enregistrement","Succes");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		if(id > 0){
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nouveau statut ajouté avec succes", null));  
		}
		else{
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Echec de creation", null));  
		}
	}

}
