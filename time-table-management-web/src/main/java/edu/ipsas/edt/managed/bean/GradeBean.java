package edu.ipsas.edt.managed.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.GradeDto;
import edu.ipsas.edt.service.EnseignantService;


@ManagedBean(name="gradeBean")
@ViewScoped
public class GradeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private EnseignantService enseignantService;
	
	private GradeDto gradeDto;
	private Collection<GradeDto> grades;

	public GradeBean(){
		gradeDto = new GradeDto();
	}
	
	// enregistrer un grade
	public void save(){
		
		long id = getEnseignantService().addGrade(gradeDto);
		if(id > 0){
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nouveau grade ajouté avec succes", null));  
		}
		else{
			 FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Echec de creation", null));  
		}
	}
	
	// liste des statuts enregistres
	
	public Collection<GradeDto> getAllGrade(){
		grades = getEnseignantService().getAllGrade();
		return grades;
	}
	
	public EnseignantService getEnseignantService() {
		return enseignantService;
	}

	public void setEnseignantService(EnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}

	public Collection<GradeDto> getGrades() {
		return grades;
	}

	public void setGrades(Collection<GradeDto> grades) {
		this.grades = grades;
	}

	public GradeDto getGradeDto() {
		return gradeDto;
	}

	public void setGradeDto(GradeDto gradeDto) {
		this.gradeDto = gradeDto;
	}
	
	
}
