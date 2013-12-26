package services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Role;
import model.User;
import services.RoleService;
import utils.AbstractDaoImpl;

@SuppressWarnings("serial")
@Service("roleService")
@Transactional
public class RoleServiceImpl extends AbstractDaoImpl<Role, Integer> implements RoleService {

	private RoleService roleService;
	
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public Role createRole(Role role) {
		return roleService.insert(role);
	}

	public Role readRole(int idRole) {
		return roleService.find(idRole);
	}

	public Role updateRole(Role role) {
		return roleService.update(role);
	}

	public void deleteRole(Role role) {
		roleService.delete(role);
	}
	
	public List<User> getAllUsers(Role role){
		List<User> users = new ArrayList<User>();
		for(User user : role.getUsers()){
			users.add(user);
		}
		return users;
	}

}
