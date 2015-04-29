package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import edu.ipsas.edt.dto.TypeSalleDto;
import edu.ipsas.edt.service.SalleService;

@ManagedBean
@ViewScoped
public class TypeSalleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private SalleService salleService;
	private String nom;

	public void save() {
		TypeSalleDto typeSalle = new TypeSalleDto();
		typeSalle.setNom(getNom());

		long id = salleService.addTypeSalle(typeSalle);

		if (id > 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Enregistrement", "Succes");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	}

	public Collection<TypeSalleDto> getAllTypeSalle() {

		return salleService.getAllTypeSalle();
	}

	public SalleService getSalleService() {
		return salleService;
	}

	public void setSalleService(SalleService salleService) {
		this.salleService = salleService;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
