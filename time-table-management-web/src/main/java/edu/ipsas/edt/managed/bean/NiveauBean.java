package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.NiveauDto;
import edu.ipsas.edt.service.DepartementService;

@ManagedBean(name="niveauBean")
@ViewScoped
public class NiveauBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DepartementService departementService;
	
	private NiveauDto niveauDto;
	private long selectedParcours;

	public NiveauBean() {
		super();
		niveauDto = new NiveauDto();
	}
	
	public String save(){
		
		niveauDto.setParcoursDto(departementService.getParcoursParId(selectedParcours));
		
		long id = departementService.addNiveau(niveauDto);
		
		if(id > 0){
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nouveau niveau ajouté avec succes", null));  
		}
		else{
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Echec de creation", null));  
		}
		return null;
	}

	public Collection<NiveauDto> getAllNiveau(){
		
		return departementService.getAllNiveau();
	}

	public DepartementService getDepartementService() {
		return departementService;
	}

	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}

	public NiveauDto getNiveauDto() {
		return niveauDto;
	}

	public void setNiveauDto(NiveauDto niveauDto) {
		this.niveauDto = niveauDto;
	}

	public long getSelectedParcours() {
		return selectedParcours;
	}

	public void setSelectedParcours(long selectedParcours) {
		this.selectedParcours = selectedParcours;
	}
	
	
	
}
