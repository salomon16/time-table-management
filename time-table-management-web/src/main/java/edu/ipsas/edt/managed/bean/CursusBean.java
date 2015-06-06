package edu.ipsas.edt.managed.bean;

import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import edu.ipsas.edt.dto.CursusDto;
import edu.ipsas.edt.dto.DepartementDto;
import edu.ipsas.edt.service.DepartementService;

@ManagedBean
@RequestScoped
public class CursusBean {

	@EJB 
	private DepartementService departementService;
	private String nom;
	private String departement;
		 
		public void save(){
			
			CursusDto cursus = new CursusDto();
			cursus.setNom(getNom());
			DepartementDto departementDto = departementService.getDepartementByName(departement);
			cursus.setDepartementDto(departementDto);
			
			long id = getDepartementService().addCursus(cursus);
			
			if(id > 0){
				FacesContext fc = FacesContext.getCurrentInstance();  
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cursus ajouté avec succes", null));  
			}
		}
		
		public Collection<CursusDto> getAllCursus(){
			return departementService.getAllCursus();
		}
		
		public String getDepartement() {
			return departement;
		}

		public void setDepartement(String departement) {
			this.departement = departement;
		}

//		public Collection<DepartementDto> getAllDepartement(){
//			
//			return getEnseignantService().getAllDepartement();
//		}
		
		
		public String getNom() {
			return nom;
		}
		public DepartementService getDepartementService() {
			return departementService;
		}

		public void setDepartementService(DepartementService departementService) {
			this.departementService = departementService;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}
		
		
}
