package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.GroupeDto;
import edu.ipsas.edt.dto.NiveauDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.service.DepartementService;

@ManagedBean(name="groupeBean")
@ViewScoped
public class GroupeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DepartementService departementService;
	private GroupeDto groupeDto;
	private String abbreviation;
	private long niveau;
	private long selectedParcours;
	private Collection<NiveauDto> listeNiveaux;
	
	public GroupeBean() {
		super();
		groupeDto = new GroupeDto();
	}
	
	public String save(){
		groupeDto.setAbbreviation(abbreviation);
		groupeDto.setNiveauDto(departementService.getAllNiveauById(niveau));
		
		long id = departementService.addGroupe(groupeDto);
		if(id > 0){
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nouveau groupe ajouté avec succes", null));  
		}
		else{
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Echec de creation", null));  
		}
		
		return null;
	}
	
	 public void onParcoursChange() {
	        if(selectedParcours != 0){
	        	System.out.println("Parcours Id: "+selectedParcours);
	    		ParcoursDto parcours = departementService.getParcoursParId(selectedParcours);
	    		System.out.println("Parcours Info: "+parcours.getNom());
	    		listeNiveaux =  departementService.getAllNiveauByParcours(parcours.getParcoursId());
	    		System.out.println("Liste Niveaux size:"+listeNiveaux.size());
	        }
	        else{
	        	listeNiveaux = new ArrayList<NiveauDto>();
	        }
	    }
	 
	public DepartementService getDepartementService() {
		return departementService;
	}

	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}

	public GroupeDto getGroupeDto() {
		return groupeDto;
	}
	public void setGroupeDto(GroupeDto groupeDto) {
		this.groupeDto = groupeDto;
	}
	public long getNiveau() {
		return niveau;
	}
	public void setNiveau(long niveau) {
		this.niveau = niveau;
	}

	public long getSelectedParcours() {
		return selectedParcours;
	}

	public void setSelectedParcours(long selectedParcours) {
		this.selectedParcours = selectedParcours;
	}

	public Collection<NiveauDto> getListeNiveaux() {
		return listeNiveaux;
	}

	public void setListeNiveaux(Collection<NiveauDto> listeNiveaux) {
		this.listeNiveaux = listeNiveaux;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	

}
