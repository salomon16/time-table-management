package edu.ipsas.edt.managed.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.ipsas.edt.service.EnseignantService;

@ManagedBean
@ViewScoped
public class CreneauBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	EnseignantService enseignantService;
	
	//helloooooooooooooooooooo

}
