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
import edu.ipsas.edt.service.EmploiDuTempsService;
import edu.ipsas.edt.service.EnseignantService;

@ManagedBean(name="groupeBean")
@ViewScoped
public class GroupeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmploiDuTempsService emploiService;
	@EJB
	private EnseignantService enseignantService;
	private GroupeDto groupeDto;
	private long niveau;
	private long selectedParcours;
	private Collection<NiveauDto> listeNiveaux;
	
	public GroupeBean() {
		super();
		groupeDto = new GroupeDto();
	}
	
	public String save(){
		groupeDto.setNiveauDto(emploiService.obtenirNiveauParId(niveau));
		
		long id = emploiService.ajouterGroupe(groupeDto);
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
	    		ParcoursDto parcours = emploiService.obtenirParcoursParId(selectedParcours);
	    		System.out.println("Parcours Info: "+parcours.getNom());
	    		listeNiveaux =  emploiService.obtenirLesNiveauxParParcours(parcours.getParcoursID());
	    		System.out.println("Liste Niveaux size:"+listeNiveaux.size());
	        }
	        else{
	        	listeNiveaux = new ArrayList<NiveauDto>();
	        }
	    }
	 
	public EmploiDuTempsService getEmploiService() {
		return emploiService;
	}
	public void setEmploiService(EmploiDuTempsService emploiService) {
		this.emploiService = emploiService;
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

	public EnseignantService getEnseignantService() {
		return enseignantService;
	}

	public void setEnseignantService(EnseignantService enseignantService) {
		this.enseignantService = enseignantService;
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
	
	

}
