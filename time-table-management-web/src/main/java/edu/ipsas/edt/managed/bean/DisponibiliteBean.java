package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import edu.ipsas.edt.service.EnseignantService;

@ManagedBean(name="disponibiliteBean")
@ViewScoped
public class DisponibiliteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EnseignantService enseignantService;

	private DualListModel<String> jours;
	
	private List<String> target;
	
	public DisponibiliteBean() {
		List<String> source = new ArrayList<String>();
		target = new ArrayList<String>();
		
		source.add("Lundi");
		source.add("Mardi");
		source.add("Mercredi");
		source.add("Jeudi");
		source.add("Vendredi");
		source.add("Samedi");
		source.add("Dimanche");
		
		jours = new DualListModel<String>(source, target);
		
	}
	public EnseignantService getEnseignantService() {
		return enseignantService;
	}

	public void setEnseignantService(EnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}
	public DualListModel<String> getJours() {
		return jours;
	}
	public void setJours(DualListModel<String> jours) {
		this.jours = jours;
	}
	public List<String> getTarget() {
		return target;
	}

	public void setTarget(List<String> target) {
		this.target = target;
	}

	
}
