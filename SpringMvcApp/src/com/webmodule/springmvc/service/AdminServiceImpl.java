package com.webmodule.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.webmodule.springmvc.bean.AdminBean;
import com.webmodule.springmvc.dao.AdminDao;
import com.webmodule.springmvc.model.Admin;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	public AdminServiceImpl() {
		System.out.println("AdminServiceImpl ");
	}

	@Autowired
	private AdminDao adminDao;
	@Override
	@Transactional
	public void addAdmin(Admin admin) {
		adminDao.addAdmin(admin);
	}

	public List<Admin> listAdmin() {
		return adminDao.listAdmin();
	}

	@Override
	public void deleteAdmin(Admin admin) {
		adminDao.deleteAdmin(admin);
	}

	@Override
	public Admin getAdminById(int id) {
		return adminDao.getAdminById(id);
	}

	public boolean checkUsername(String username) {
		return adminDao.checkUsername(username);
	}

	@Override
	public boolean checkPassword(String password) {
		return adminDao.checkPassword(password);
	}

	@Override
	public Admin findByUsername(String username) {
		return adminDao.findByUsername(username);
	}

	
	/*@Override
	public AdminBean findByUsernameForAdd(String username) {
		return adminDao.findByUsernameForAdd(username);
	}*/


	/*
	 * public Admin validateAdmin(Login login) { adminDao.validateAdmin(login);
	 * return null; }
	 * 
	 * public void updateAdmin(Admin admin) { }
	 */
}
