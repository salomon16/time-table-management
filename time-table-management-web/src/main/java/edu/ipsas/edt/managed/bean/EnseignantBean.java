package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.EnseignantDto;
import edu.ipsas.edt.dto.GradeDto;
import edu.ipsas.edt.dto.StatutDto;
import edu.ipsas.edt.service.EnseignantService;

@ManagedBean(name="enseignantBean")
@SessionScoped
public class EnseignantBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private EnseignantService enseignantService;

	private Collection<StatutDto> statuts;

	private Collection<GradeDto> grades;

	private Collection<EnseignantDto> enseignants;

	private EnseignantDto selectedEnseignant;

	private String nom;

	private String prenom;

	private String cin;

	private String adresse;

	private String email;

	private String telephoneMobile;

	private String specialite;

	private String statut;

	private String grade;

	//methode pour la creation d'un enseignant
	public void save() {
		EnseignantDto enseignant = new EnseignantDto();
		enseignant.setNom(getNom());
		enseignant.setPrenom(getPrenom());
		enseignant.setCin(getCin());
		enseignant.setAdresse(getAdresse());
		enseignant.setTelephoneMobile(getTelephoneMobile());
		enseignant.setEmail(getEmail());
		enseignant.setSpecialite(getSpecialite());
		enseignant.setStatutDto(enseignantService.getStatutByName(getStatut()));
		enseignant.setGradeDto(enseignantService.getGradeByName(grade));

		long id = getEnseignantService().addEnseignant(enseignant);
		
		if(id > 0){
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nouvel enseignant ajouté avec succes", null));  
		}
		else{
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Echec de creation", null));  
		}
	}
	
	//methode pour recuperer l'enseignant selectionné
	public void selectEnseignant(long selectEnseignantId) {

		setSelectedEnseignant(enseignantService
				.getEnseignantByCode(selectEnseignantId));
		System.out.println("Selected Enseignant iD: "
				+ selectedEnseignant.getEnseignantID());
	}

	//methode pour la mise a jour d'un enseignant
	public void update() {

		if (!statut.equals(selectedEnseignant.getStatutDto().getNom()))
			getSelectedEnseignant().setStatutDto(
					enseignantService.getStatutByName(getStatut()));

		if (!grade.equals(selectedEnseignant.getGradeDto().getNom()))
			getSelectedEnseignant().setGradeDto(
					enseignantService.getGradeByName(getGrade()));

		enseignantService.updateEnseignant(selectedEnseignant);

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Enseignant mis à jour"));

	}
	//methode pour la suppression d'un enseignant
	public void delete() {
		
		getEnseignantService().deleteEnseignant(selectedEnseignant);
		
	}
	
	//methode pour la recuperation de tout les statuts
	public Collection<StatutDto> getAllStatuts() {
		
		return getEnseignantService().getAllStatut();
	
	}
	//methode pour la recuperation de tout les grades
	public Collection<GradeDto> getAllGrades() {
		
		return getEnseignantService().getAllGrade();
	}

	// La methode getAllEnseignant recupère tout les enseignants de la base de
	// donnée
	public Collection<EnseignantDto> getAllEnseignant() {
		
		return enseignantService.getAllEnseignant();
	}

	public EnseignantService getEnseignantService() {
		return enseignantService;
	}

	public void setEnseignantService(EnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}

	public Collection<StatutDto> getStatuts() {
		return statuts;
	}

	public void setStatuts(Collection<StatutDto> statuts) {
		this.statuts = statuts;
	}

	public Collection<GradeDto> getGrades() {
		return grades;
	}

	public void setGrades(Collection<GradeDto> grades) {
		this.grades = grades;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<EnseignantDto> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Collection<EnseignantDto> enseignants) {
		this.enseignants = enseignants;
	}

	public EnseignantDto getSelectedEnseignant() {
		return selectedEnseignant;
	}

	public void setSelectedEnseignant(EnseignantDto selectedEnseignant) {
		this.selectedEnseignant = selectedEnseignant;
	}

}
