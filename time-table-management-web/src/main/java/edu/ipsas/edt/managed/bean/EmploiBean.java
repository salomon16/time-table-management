package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.DualListModel;

import edu.ipsas.edt.dto.EnseignantDto;
import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.dto.SalleDto;
import edu.ipsas.edt.service.EmploiDuTempsService;

@ManagedBean(name="emploiBean")
@ViewScoped
public class EmploiBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private EmploiDuTempsService emploiService;
	
	private Date dateDebut;
	
	private Date dateFin;
	
	private boolean skip;
	
	private int anneeCourante = Calendar.YEAR;
	
	private DualListModel<String> jours;
	
	private List<String> target;
	
	private List<String> source;
	
	private Date horaireDebut; 
	
	private Date horaireFin;
	
	private Collection<EnseignantDto> enseignants;
	
	private Collection<MatiereDto> matieres;
	
	private Collection<SalleDto> salles;
	
	 	@PostConstruct
	    public void init() {
	 		source = new ArrayList<String>();
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
	 	 public void onDrop(DragDropEvent event) {  
//	         Player player = (Player) event.getData();  
//	   
//	         selectedPlayers.add(player);  
//	   
//	         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(player.getName() + " added", "Position:" + event.getDropId()));  
	     }  
	 public String getFormattedHoraireDebut() {  
	        return getFormattedTime(horaireDebut, "hh-mm a");  
	    }  
	 
	 public String getFormattedHoraireFin() {  
	        return getFormattedTime(horaireFin, "hh-mm a");  
	    }  
	  
	
	private String getFormattedTime(Date time, String format) {  
        if (time == null) {  
            return null;  
        }  
  
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);  
  
        return simpleDateFormat.format(time);  
    }  
	
	 public String onFlowProcess(FlowEvent event) {
	        if(skip) {
	            skip = false;   //reset in case user goes back
	            return "confirm";
	        }
	        else {
	            return event.getNewStep();
	        }
	    }

	public boolean isSkip() {
		return skip;
	}
	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	public EmploiDuTempsService getEmploiService() {
		return emploiService;
	}
	public void setEmploiService(EmploiDuTempsService emploiService) {
		this.emploiService = emploiService;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getAnneeCourante() {
		return anneeCourante;
	}

	public void setAnneeCourante(int anneeCourante) {
		this.anneeCourante = anneeCourante;
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
	public Date getHoraireDebut() {
		return horaireDebut;
	}
	public void setHoraireDebut(Date horaireDebut) {
		this.horaireDebut = horaireDebut;
	}
	public Date getHoraireFin() {
		return horaireFin;
	}
	public void setHoraireFin(Date horaireFin) {
		this.horaireFin = horaireFin;
	}
	public List<String> getSource() {
		return source;
	}
	public void setSource(List<String> source) {
		this.source = source;
	}
	public Collection<EnseignantDto> getEnseignants() {
		return enseignants;
	}
	public void setEnseignants(Collection<EnseignantDto> enseignants) {
		this.enseignants = enseignants;
	}
	public Collection<MatiereDto> getMatieres() {
		return matieres;
	}
	public void setMatieres(Collection<MatiereDto> matieres) {
		this.matieres = matieres;
	}
	public Collection<SalleDto> getSalles() {
		return salles;
	}
	public void setSalles(Collection<SalleDto> salles) {
		this.salles = salles;
	}

}
