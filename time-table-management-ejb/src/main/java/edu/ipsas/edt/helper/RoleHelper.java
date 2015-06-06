package edu.ipsas.edt.helper;

import java.util.ArrayList;
import java.util.Collection;

import edu.ipsas.edt.dto.RoleDto;
import edu.ipsas.edt.model.Role;


public class RoleHelper {

	public static Role dtoToModel(RoleDto roleDto){
		
		if(roleDto == null)
			return null;
		
		Role role = new Role();
		role.setType(roleDto.getType());
		role.setPersonnelsAdministratif(PersonnelAdministratifHelper.dtoToModels(roleDto.getPersonnelsAdministratif()));
		
		return role;
	}
	
	public static RoleDto modelToDto(Role role){
		
		if(role == null)
			return null;
		
		RoleDto roleDto = new RoleDto();
		roleDto.setType(role.getType());
		roleDto.setPersonnelsAdministratif(PersonnelAdministratifHelper.modelsToDto(role.getPersonnelsAdministratif()));
		
		return roleDto;
	}
	
	public static Collection<Role> dtoToModels(Collection<RoleDto> rolesDto){
		Collection<Role> roles = new ArrayList<Role>();
		
		for(RoleDto roleDto : rolesDto){
			roles.add(dtoToModel(roleDto));
		}
		
		return roles;
	}
	
	public static Collection<RoleDto> modelsToDto(Collection<Role> roles){
		Collection<RoleDto> rolesDto = new ArrayList<RoleDto>();
		
		for(Role role : roles){
			rolesDto.add(modelToDto(role));
		}
		
		return rolesDto;
	}
}
