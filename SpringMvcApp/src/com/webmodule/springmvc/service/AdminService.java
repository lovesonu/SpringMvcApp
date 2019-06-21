package com.webmodule.springmvc.service;

import java.util.List;

import com.webmodule.springmvc.bean.AdminBean;
import com.webmodule.springmvc.model.Admin;

public interface AdminService {
	public void addAdmin(Admin user);

	public List<Admin> listAdmin();

	public void deleteAdmin(Admin admin);

	public Admin getAdminById(int id);

	public boolean checkUsername(String username);

	public boolean checkPassword(String password);

	Admin findByUsername(String username);


	// public Admin doLogin(String username, String password);
	/*
	 * public void updateAdmin(Admin user);
	 */

}
