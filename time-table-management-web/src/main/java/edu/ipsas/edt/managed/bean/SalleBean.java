package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import edu.ipsas.edt.dto.SalleDto;
import edu.ipsas.edt.dto.TypeSalleDto;
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
	private String numero;
	private String capacite;
	private String nomTypeSalle;
	private TypeSalleDto typeSalleDto;
	
	
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
		try {
			salle.setCapacite(Integer.parseInt(getCapacite()));
		} catch (NumberFormatException number) {
			System.out.println("Erreur de conversion");
		}

		salle.setTypeSalleDto(salleService.getTypeSalleByName(getNomTypeSalle()));
		
		long id = getSalleService().addSalle(salle);
		
		if(id > 0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Enregistrement","Succes");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
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
	
	public TypeSalleDto getTypeSalleDto() {
		return typeSalleDto;
	}
	public void setTypeSalleDto(TypeSalleDto typeSalleDto) {
		this.typeSalleDto = typeSalleDto;
	}

	public String getCapacite() {
		return capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	
	
} 
