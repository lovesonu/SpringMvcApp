package com.webmodule.springmvc.dao;

import java.util.List;

import com.webmodule.springmvc.bean.AdminBean;
import com.webmodule.springmvc.model.Admin;

public interface AdminDao {

	public void addAdmin(Admin admin);

	public List<Admin> listAdmin();

	public void deleteAdmin(Admin admin);

	public Admin getAdminById(int id);

	public boolean checkUsername(String username);

	public boolean checkPassword(String password);

	Admin findByUsername(String username);
	
	public void getAllStates();
	


	/*
	 * public void updateAdmin(Admin admin); public Admin doLogin(String username,
	 * String password);
	 * 
	 */
}
