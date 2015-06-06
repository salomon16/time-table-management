package edu.ipsas.edt.managed.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.ipsas.edt.dto.PersonnelAdministratifDto;
import edu.ipsas.edt.service.EnseignantService;


@ManagedBean(name="personnelBean")
@ViewScoped
public class PersonnelAdministratifBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	EnseignantService enseignantService;
	PersonnelAdministratifDto user;
	
	
	public PersonnelAdministratifBean() {
		super();
		user = new PersonnelAdministratifDto();
	}
	
	public void save(){
		
	}
	
	public EnseignantService getEnseignantService() {
		return enseignantService;
	}
	public void setEnseignantService(EnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}
	public PersonnelAdministratifDto getUser() {
		return user;
	}
	public void setUser(PersonnelAdministratifDto user) {
		this.user = user;
	}
	
	

}
