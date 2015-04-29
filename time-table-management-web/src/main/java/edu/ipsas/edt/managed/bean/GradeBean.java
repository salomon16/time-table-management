package edu.ipsas.edt.managed.bean;

import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import edu.ipsas.edt.dto.GradeDto;
import edu.ipsas.edt.service.EnseignantService;


@ManagedBean
@RequestScoped
public class GradeBean {

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
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Enregistrement","Succes");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	}
	
	// liste des statuts enregistr�s
	
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
