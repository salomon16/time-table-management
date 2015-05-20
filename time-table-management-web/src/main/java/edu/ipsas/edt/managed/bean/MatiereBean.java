package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.dto.UniteDto;
import edu.ipsas.edt.service.EmploiDuTempsService;

@ManagedBean(name="matiereBean")
@ApplicationScoped
public class MatiereBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmploiDuTempsService emploiDuTempsService;
	
	private String nom;

	private String description;

	private String type;

	private float volumeC;

	private float volumeTP;

	private float volumeTD;

	private float credit;

	private int coefficient;

	private long unite;
	
//	public MatiereBean() {
//		super();
//		matiereDto = new MatiereDto();
//	}

	public void save(){
		
		MatiereDto matiereDto = new MatiereDto(nom, type, volumeC, volumeTP, volumeTD, credit, coefficient);
		UniteDto uniteDto = emploiDuTempsService.obtenirUniteParId(unite);
		
		matiereDto.setUniteDto(uniteDto);
		long id = emploiDuTempsService.ajouterMatiere(matiereDto);
		
		if(id>0){
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nouvelle matiere ajouté avec succes", null));  
		}
	}
	
	public Collection<MatiereDto> getAllMatiere(){
		return emploiDuTempsService.obtenirLesMatieres();
	}
	public EmploiDuTempsService getEmploiDuTempsService() {
		return emploiDuTempsService;
	}

	public void setEmploiDuTempsService(EmploiDuTempsService emploiDuTempsService) {
		this.emploiDuTempsService = emploiDuTempsService;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getVolumeC() {
		return volumeC;
	}

	public void setVolumeC(float volumeC) {
		this.volumeC = volumeC;
	}

	public float getVolumeTP() {
		return volumeTP;
	}

	public void setVolumeTP(float volumeTP) {
		this.volumeTP = volumeTP;
	}

	public float getVolumeTD() {
		return volumeTD;
	}

	public void setVolumeTD(float volumeTD) {
		this.volumeTD = volumeTD;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public long getUnite() {
		return unite;
	}

	public void setUnite(long unite) {
		this.unite = unite;
	}
	
}
