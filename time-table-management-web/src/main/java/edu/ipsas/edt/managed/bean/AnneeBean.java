package edu.ipsas.edt.managed.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import edu.ipsas.edt.service.EmploiDuTempsService;

@ManagedBean(name="anneeBean")
public class AnneeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmploiDuTempsService emploiService;
	
	private int debutAnnee;
	private int finAnnee;
	
	public String save(){
		
		return null;
	}
	public EmploiDuTempsService getEmploiService() {
		return emploiService;
	}
	public void setEmploiService(EmploiDuTempsService emploiService) {
		this.emploiService = emploiService;
	}
	public int getDebutAnnee() {
		return debutAnnee;
	}
	public void setDebutAnnee(int debutAnnee) {
		this.debutAnnee = debutAnnee;
	}
	public int getFinAnnee() {
		return finAnnee;
	}
	public void setFinAnnee(int finAnnee) {
		this.finAnnee = finAnnee;
	}

	
	
}
