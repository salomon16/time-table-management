package edu.ipsas.edt.dao;

import javax.ejb.Local;

import edu.ipsas.edt.model.Role;

@Local
public interface RoleDao extends GenericDao<Role>{

	public Role findRoleByName(String name);
}
