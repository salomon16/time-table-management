package edu.ipsas.edt.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.ipsas.edt.dao.EtablissementDao;
import edu.ipsas.edt.dao.RessourceDao;
import edu.ipsas.edt.dao.SalleDao;
import edu.ipsas.edt.dao.TypeSalleDao;
import edu.ipsas.edt.dto.EtablissementDto;
import edu.ipsas.edt.dto.RessourceDto;
import edu.ipsas.edt.dto.SalleDto;
import edu.ipsas.edt.dto.TypeSalleDto;
import edu.ipsas.edt.helper.EtablissementHelper;
import edu.ipsas.edt.helper.RessourceHelper;
import edu.ipsas.edt.helper.SalleHelper;
import edu.ipsas.edt.helper.TypeSalleHelper;
import edu.ipsas.edt.model.Etablissement;
import edu.ipsas.edt.model.Ressource;
import edu.ipsas.edt.model.Salle;
import edu.ipsas.edt.model.TypeSalle;
import edu.ipsas.edt.service.SalleService;

@Stateless
public class SalleServiceImpl implements SalleService {
	
	@EJB 
	private EtablissementDao etablissementDao;
	@EJB 
	private SalleDao salleDao;
	@EJB 
	private TypeSalleDao typeSalleDao;
	@EJB 
	private RessourceDao ressourceDao;

	public void updateEtablissement(EtablissementDto etablissementDto) {
		etablissementDao.update(EtablissementHelper.dtoToModel(etablissementDto));
	}
	public String addEtablissement(EtablissementDto etablissementDto) {
		
		Etablissement etablissement = new Etablissement();
		 etablissement = EtablissementHelper.dtoToModel(etablissementDto);
		 etablissementDao.create(etablissement);
		return etablissement.getEtablissementID();
	}
	public long addSalle(SalleDto salleDto) {
		
		Salle salle = new Salle();
		salle = SalleHelper.dtoToModel(salleDto);
		salleDao.create(salle);
		return salle.getSalleId();
	}
	public void updateSalle(SalleDto salleDto) {
		salleDao.update(SalleHelper.dtoToModel(salleDto));
	}
	public void deleteSalle(SalleDto salleDto) {
	salleDao.delete(salleDto.getSalleId());

	}
	public Collection<SalleDto> getAllSalle() {
	
		return SalleHelper.modelsToDto(salleDao.findAll());
	}
	public long addRessource(RessourceDto ressourceDto) {
		
		Ressource ressource = new Ressource();
		ressource = RessourceHelper.dtoToModel(ressourceDto);
		ressourceDao.create(ressource);
		return ressource.getRessourceID();
	}
	public void updateRessource(RessourceDto ressourceDto) {
		ressourceDao.update(RessourceHelper.dtoToModel(ressourceDto));
	}
	public void deleteRessource(RessourceDto ressourceDto) {
		ressourceDao.delete(ressourceDto.getRessourceID());
	}
	public Collection<RessourceDto> getAllRessource() {
		
		return RessourceHelper.modelsToDto(ressourceDao.findAll());
	}
	public long addTypeSalle(TypeSalleDto typeSalleDto) {
		
		TypeSalle typeSalle = TypeSalleHelper.dtoToModel(typeSalleDto);
		typeSalleDao.create(typeSalle);
		return typeSalle.getTypeSalleId();
	}
	public void updateTypeSalle(TypeSalleDto typeSalleDto) {
		typeSalleDao.update(TypeSalleHelper.dtoToModel(typeSalleDto));
	}
	public void deleteTypeSalle(TypeSalleDto typeSalleDto) {

		typeSalleDao.delete(typeSalleDto.getTypeSalleId());
	}
	public Collection<TypeSalleDto> getAllTypeSalle() {
		
		return TypeSalleHelper.modelsToDto(typeSalleDao.findAll());
	}
	public TypeSalleDto getTypeSalleByName(String name) {
		return TypeSalleHelper.modelToDto(typeSalleDao.findTypeSalleByName(name));
	}
	public EtablissementDao getEtablissementDao() {
		return etablissementDao;
	}
	public void setEtablissementDao(EtablissementDao etablissementDao) {
		this.etablissementDao = etablissementDao;
	}
	public SalleDao getSalleDao() {
		return salleDao;
	}
	public void setSalleDao(SalleDao salleDao) {
		this.salleDao = salleDao;
	}
	public TypeSalleDao getTypeSalleDao() {
		return typeSalleDao;
	}
	public void setTypeSalleDao(TypeSalleDao typeSalleDao) {
		this.typeSalleDao = typeSalleDao;
	}
	public RessourceDao getRessourceDao() {
		return ressourceDao;
	}
	public void setRessourceDao(RessourceDao ressourceDao) {
		this.ressourceDao = ressourceDao;
	}
	
	public Collection<SalleDto> getAllSalleByDepartement(String departementName) {
		
		return SalleHelper.modelsToDto(salleDao.findAllSalleByDepartement(departementName));
	}
}
