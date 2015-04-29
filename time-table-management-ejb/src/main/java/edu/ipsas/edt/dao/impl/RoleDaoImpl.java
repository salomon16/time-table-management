package edu.ipsas.edt.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;

import edu.ipsas.edt.dao.RoleDao;
import edu.ipsas.edt.model.Role;

@Stateless
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {

	 @SuppressWarnings("unchecked")
		public Collection<Role> findAll(){
	    	return em.createQuery("select r from Role r").getResultList();
	    }

	
	public Role findRoleByName(String name) {
		
		return null;
	}
}
