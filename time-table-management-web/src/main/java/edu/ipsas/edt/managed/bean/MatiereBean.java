package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.dto.UniteDto;
import edu.ipsas.edt.service.DepartementService;

@ManagedBean(name="matiereBean")
@ViewScoped
public class MatiereBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DepartementService departementService;
	
	private String nom;

	private float nombreHeure;
	
	private String description;

	private String type;

	private float volumeC;

	private float volumeTP;

	private float volumeTD;

	private float credit;

	private int coefficient;

	private long unite;
	
	public void save(){
		
		MatiereDto matiereDto = new MatiereDto(nom, nombreHeure, type, volumeC, volumeTP, volumeTD, credit, coefficient);
		UniteDto uniteDto = departementService.getUniteById(unite);
		
		matiereDto.setUniteDto(uniteDto);
		long id = departementService.addMatiere(matiereDto);
		
		if(id>0){
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nouvelle matiere ajouté avec succes", null));  
		}
	}
	
	public Collection<MatiereDto> getAllMatiere(){
		return departementService.getAllMatiere();
	}

	public DepartementService getDepartementService() {
		return departementService;
	}

	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
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

	public float getNombreHeure() {
		return nombreHeure;
	}

	public void setNombreHeure(float nombreHeure) {
		this.nombreHeure = nombreHeure;
	}
	
}
