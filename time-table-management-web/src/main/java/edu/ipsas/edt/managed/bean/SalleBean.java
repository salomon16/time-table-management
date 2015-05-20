package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.SalleDto;
import edu.ipsas.edt.dto.TypeSalleDto;
import edu.ipsas.edt.service.EnseignantService;
import edu.ipsas.edt.service.SalleService;

@ManagedBean
@ViewScoped
public class SalleBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	private SalleService salleService;
	@EJB 
	private EnseignantService enseignantService;
	
	private String numero;
	private int capacite;
	private String nomTypeSalle;
	private String typeSalle;
	private String departement;
	
	
	public Collection<SalleDto> getAllSalle(){
		Collection<SalleDto> salles = getSalleService().getAllSalle();
		
		return salles;
	}
	
	public Collection<TypeSalleDto> getAllTypeSalle(){
		
		Collection<TypeSalleDto> typeSalles = getSalleService().getAllTypeSalle();
		
		return typeSalles;
	}
	
	public void save(){
		
		SalleDto salle = new SalleDto();
		salle.setNumero(getNumero());
		salle.setCapacite(getCapacite());
		
		salle.setTypeSalle(nomTypeSalle);
		
		salle.setDepartementDto(enseignantService.getDepartementByName(departement));
		
		long id = getSalleService().addSalle(salle);
		
		if(id > 0){
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nouvelle salle ajouté avec succes", null));
		}
	}
	
	public String getNomTypeSalle() {
		return nomTypeSalle;
	}

	public void setNomTypeSalle(String nomTypeSalle) {
		this.nomTypeSalle = nomTypeSalle;
	}

	public SalleService getSalleService() {
		return salleService;
	}

	public void setSalleService(SalleService salleService) {
		this.salleService = salleService;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTypeSalle() {
		return typeSalle;
	}

	public void setTypeSalle(String typeSalle) {
		this.typeSalle = typeSalle;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public EnseignantService getEnseignantService() {
		return enseignantService;
	}

	public void setEnseignantService(EnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}
	
	
	
} 
