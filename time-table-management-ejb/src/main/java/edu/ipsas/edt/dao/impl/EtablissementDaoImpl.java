package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.EtablissementDao;
import edu.ipsas.edt.model.Etablissement;

@Stateless
public class EtablissementDaoImpl extends GenericDaoImpl<Etablissement> implements EtablissementDao {

	 @SuppressWarnings("unchecked")
		public Collection<Etablissement> findAll(){
	    	return em.createQuery("select e from Etablissement e").getResultList();
	    }
}
