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
import javax.faces.component.UIComponent;

import org.primefaces.component.selectmanymenu.SelectManyMenu;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.DualListModel;

import edu.ipsas.edt.dto.CreneauDto;
import edu.ipsas.edt.dto.DepartementDto;
import edu.ipsas.edt.dto.EnseignantDto;
import edu.ipsas.edt.dto.GroupeDto;
import edu.ipsas.edt.dto.MatiereDto;
import edu.ipsas.edt.dto.ParcoursDto;
import edu.ipsas.edt.dto.PlanEtudeDto;
import edu.ipsas.edt.dto.SalleDto;
import edu.ipsas.edt.dto.SemestreDto;
import edu.ipsas.edt.service.DepartementService;
import edu.ipsas.edt.service.EmploiDuTempsService;
import edu.ipsas.edt.service.EnseignantService;
import edu.ipsas.edt.service.SalleService;

@ManagedBean(name="emploiBean")
@ViewScoped
public class EmploiBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int currentLevel = 1;  
	
	@EJB
	private EmploiDuTempsService emploiService;
	
	@EJB
	private DepartementService departementService;
	
	@EJB
	private EnseignantService enseignantService;
	
	@EJB
	private SalleService salleService;
	
	private Date dateDebut;
	
	private Date dateFin;
	
	private boolean skip;
	
	private int anneeCourante = Calendar.YEAR;
	
	private DualListModel<String> jours;
	
	private List<String> target;
	
	private List<String> source;
	
	private Date horaireDebut; 
	
	private Date horaireFin;
	
	private String selectedDepartement;
	
	private long selectedParcours;
	
	private long selectedGroupe;
	
	private long selectedSemestre;
	
	private Collection<ParcoursDto> parcours;
	
	private Collection<GroupeDto> groupes;
	
	private Collection<MatiereDto> matieres;
	
	private Collection<SalleDto> salles;
	
	private Collection<PlanEtudeDto> plansEtude;
	
	private Collection<EnseignantDto> enseignants;
	
	private ParcoursDto parcoursDto;
	
	private SemestreDto semestreDto;
	
	private DepartementDto departementDto;
	
	private SelectManyMenu selectMenu;
	
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
			
			matieres = new ArrayList<MatiereDto>();
	}
	 	public Collection<CreneauDto> getAllCreneau(){
	 		return emploiService.getAllCreneau();
	 	}
	 	
	 	public void parametrer(){
	 		System.out.println("parametrer");
	 		 if(plansEtude != null){
	 			System.out.println("plansEtude != null "+plansEtude.size());
	 			 System.out.println(matieres.size());
		 		 for(PlanEtudeDto planEtude : plansEtude){
		 			 System.out.println(matieres.size());
		 			 if(planEtude.getSemestreDto().getSemestreId() == getSelectedSemestre()){
		 				 matieres = planEtude.getMatieresDto();
		 				 System.out.println(matieres.size());
		 			 }
		 		 }
	 		 }
	 		else {
	 			matieres = new ArrayList<MatiereDto>();
	 		}
//	 		
//			 enseignants = enseignantService.getAllEnseignantByDepartement(selectedDepartement);
//	 		salles =  salleService.getAllSalleByDepartement(selectedDepartement);
	 		
	 	}
	 	public void affiche(){
	 		System.out.println("Selected  Departement"+selectedDepartement);
	 		System.out.println("Selected  Parcours"+selectedParcours);
	 		System.out.println("Selected  Groupe"+selectedGroupe);
	 		System.out.println("Selected  Semestre"+selectedSemestre);
	 	}
	 	 public void onDepartementChange() {
	 		 System.out.println("  *** onDepartementChange ");
	 		System.out.println("Semestre id"+selectedSemestre);
		        if(selectedDepartement !=null && !selectedDepartement.equals("")){
		    	   departementDto = departementService.getDepartementByName(selectedDepartement);
		    		parcours = (Collection<ParcoursDto>) departementService.getAllParcoursByDepartement(departementDto.getDepartementID());
		        }
		        else
		        	parcours = new ArrayList<ParcoursDto>();
		        System.out.println("  ***  "+parcours.size());
		    }
		 public void onParcoursChange() {
		        if(selectedParcours != 0 ){
		        	System.out.println(" ****** selectedParcours "+selectedParcours);
		    		 parcoursDto = departementService.getParcoursParId(selectedParcours);
		    		 groupes = (Collection<GroupeDto>) departementService.getAllGroupeByParcours(parcoursDto.getParcoursId());
		    		 plansEtude = departementService.getAllPlanEtudeByParcours(parcoursDto.getParcoursId());
		    		 System.out.println("Plan d'etude size:"+plansEtude.size());
		    		 if(plansEtude.size()!= 0){
		 	 			System.out.println("plansEtude != null "+plansEtude.size());
		 	 			System.out.println("Semestre id"+selectedSemestre);
		 		 		 for(PlanEtudeDto planEtude : plansEtude){
		 		 			 if(planEtude.getSemestreDto().getSemestreId() == getSelectedSemestre()){
		 		 				 matieres = planEtude.getMatieresDto();
		 		 				 System.out.println(matieres.size());
		 		 			 }
		 		 		 }
		 	 		 }
		        }
		        else
		        	groupes = new ArrayList<GroupeDto>();
		    }
		
	 	 public void onDrop(DragDropEvent event) {  
	 	 }
	 	 
	 	 public void selectAllMenu(){
	 		 List<UIComponent> children = selectMenu.getChildren();
	 		 for(int i=0; i<children.size();i++){
	 			 children.get(i).setRendered(true);
	 		 }
	 	 
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
	            return "info";
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
	public DepartementService getDepartementService() {
		return departementService;
	}
	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}
	public String getSelectedDepartement() {
		return selectedDepartement;
	}
	public void setSelectedDepartement(String selectedDepartement) {
		this.selectedDepartement = selectedDepartement;
	}
	
	public long getSelectedGroupe() {
		return selectedGroupe;
	}
	public void setSelectedGroupe(long selectedGroupe) {
		this.selectedGroupe = selectedGroupe;
	}
	public Collection<ParcoursDto> getParcours() {
		return parcours;
	}
	public void setParcours(Collection<ParcoursDto> parcours) {
		this.parcours = parcours;
	}
	public Collection<GroupeDto> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<GroupeDto> groupes) {
		this.groupes = groupes;
	}
	public long getSelectedParcours() {
		return selectedParcours;
	}
	public void setSelectedParcours(long selectedParcours) {
		this.selectedParcours = selectedParcours;
	}
	public long getSelectedSemestre() {
		return selectedSemestre;
	}
	public void setSelectedSemestre(long selectedSemestre) {
		this.selectedSemestre = selectedSemestre;
	}
	public ParcoursDto getParcoursDto() {
		return parcoursDto;
	}
	public void setParcoursDto(ParcoursDto parcoursDto) {
		this.parcoursDto = parcoursDto;
	}
	public SemestreDto getSemestreDto() {
		return semestreDto;
	}
	public void setSemestreDto(SemestreDto semestreDto) {
		this.semestreDto = semestreDto;
	}
	public DepartementDto getDepartementDto() {
		return departementDto;
	}
	public void setDepartementDto(DepartementDto departementDto) {
		this.departementDto = departementDto;
	}
	public EnseignantService getEnseignantService() {
		return enseignantService;
	}
	public void setEnseignantService(EnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}
	public SalleService getSalleService() {
		return salleService;
	}
	public void setSalleService(SalleService salleService) {
		this.salleService = salleService;
	}
	public SelectManyMenu getSelectMenu() {
		return selectMenu;
	}
	public void setSelectMenu(SelectManyMenu selectMenu) {
		this.selectMenu = selectMenu;
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
	public Collection<EnseignantDto> getEnseignants() {
		return enseignants;
	}
	public void setEnseignants(Collection<EnseignantDto> enseignants) {
		this.enseignants = enseignants;
	}
	public Collection<PlanEtudeDto> getPlansEtude() {
		return plansEtude;
	}
	public void setPlansEtude(Collection<PlanEtudeDto> plansEtude) {
		this.plansEtude = plansEtude;
	}
	public int getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	
}
