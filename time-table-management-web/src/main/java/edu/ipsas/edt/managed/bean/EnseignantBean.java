package edu.ipsas.edt.managed.bean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;

import edu.ipsas.edt.dto.EnseignantDto;
import edu.ipsas.edt.dto.GradeDto;
import edu.ipsas.edt.dto.StatutDto;
import edu.ipsas.edt.service.EnseignantService;

@ManagedBean(name="enseignantBean")
@ViewScoped
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
	
	private Collection<String> selectedDepartements;
	
	@PostConstruct
	public void init(){
		selectedDepartements = new ArrayList<String>();
	}
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
		
		for(String departement : selectedDepartements){
			enseignant.getDepartements().add(enseignantService.getDepartementByName(departement));
		}
		
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
	public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
         
        HSSFCellStyle cellStyle = wb.createCellStyle();  
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
         
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            HSSFCell cell = header.getCell(i);
             
            cell.setCellStyle(cellStyle);
        }
    }
     
    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
//        pdf.addTitle("Liste des enseignants");
 
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "prime_logo.png";
         
        pdf.add(Image.getInstance(logo));
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

	public Collection<String> getSelectedDepartements() {
		return selectedDepartements;
	}

	public void setSelectedDepartements(Collection<String> selectedDepartements) {
		this.selectedDepartements = selectedDepartements;
	}

}
