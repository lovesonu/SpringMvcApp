package com.webmodule.springmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.webmodule.springmvc.bean.AdminBean;
import com.webmodule.springmvc.bean.LoginBean;
import com.webmodule.springmvc.model.Admin;
import com.webmodule.springmvc.service.AdminService;
import com.webmodule.springmvc.service.AdminServiceImpl;

@Controller
public class AdminController {

	public AdminController() {
		System.out.println("In AdminController class ");
	}

	@Autowired
	private AdminService adminService;
	private Admin Admin = new Admin();
	AdminServiceImpl adminServiceimpl = new AdminServiceImpl();

	/*
	 * For save the Register page on click on Register button
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveAdmin(@ModelAttribute("command") AdminBean adminBean, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		Admin admin = prepareModel(adminBean);
		String username = request.getParameter("username");
		boolean userExist = adminService.checkUsername(username);
		if (admin.getName() == "" || admin.getUsername() == "" || admin.getPassword() == "") {
			System.out.println("First fill UserName and name field");
			return new ModelAndView("redirect:/addUser.html");
		}
		if (userExist) { // To check USerName is alredy register
			return new ModelAndView("redirect:/addUser.html");
		} else {
			adminService.addAdmin(admin);
			return new ModelAndView("login"); // This is forward login page
			// return new ModelAndView("redirect:/add.html"); // This is for getting whole
			// list of data
		}
	}

	// Call from when user want add new data
	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public ModelAndView addAdmin(@ModelAttribute("add") AdminBean adminBean, BindingResult result) {
		Map<String, Object> modelmap = new HashMap<String, Object>();
		modelmap.put("admins", prepareListofBean(adminService.listAdmin()));
		return new ModelAndView("addUser", modelmap);
	}

	// This is for delete data by id
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteAdmin(@ModelAttribute("command") AdminBean adminBean, BindingResult result) {
		System.out.println("value = /delete >> deleteAdmin() .........>>");
		adminService.deleteAdmin(prepareModel(adminBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("admin", null);
		model.put("admins", prepareListofBean(adminService.listAdmin()));
		return new ModelAndView("addUser", model);
	}

	// Request index page
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	// To load Register Page
	@RequestMapping(value = "/addUser.html", method = RequestMethod.GET)
	public String loadRegister(Model model) {
		System.out.println("loadRegister from controller :- loadRegister()  ------ " + model);
		model.addAttribute("registerModel", new Admin());
		return "register";
	}

	// For Getting All list of user
	@RequestMapping(value = "/admins", method = RequestMethod.GET)
	public ModelAndView listAdmins() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("admins", prepareListofBean(adminService.listAdmin()));
		return new ModelAndView("adminsList", model);
	}

	// For Login page (validation and do login)
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("admin") Admin admin, HttpServletRequest request,
			HttpServletResponse response, LoginBean loginBean, HttpSession session, AdminBean adminbean, Model model) {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		Map<String, Object> modelmap = new HashMap<String, Object>();
		modelmap.put("admins", prepareListofBean(adminService.listAdmin()));
		if (loginBean.getUsername() == null || loginBean.getPassword() == null) {
			return new ModelAndView("login");
		}
		if (loginBean.getUsername().equals("admin") && loginBean.getPassword().equals("admin")) {
			return new ModelAndView("addUser", modelmap);
		} else if (adminService.checkUsername(userName) && adminService.checkPassword(password)) {
			admin = this.adminService.findByUsername(adminbean.getUsername());
			model.addAttribute("admin", admin); // Admin that forward on jsp for getting data on view (admin.name)
			return new ModelAndView("home");
		} else {
			return new ModelAndView("login");
		}
	}

	// For logout from Home page
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("Session invalidate : Logout successfully..!");
		return "logout";

		/*
		 * session.removeAttribute("username"); session.removeAttribute("id");
		 * session.invalidate();
		 * System.out.println("Session invalidate : Logout successfully..!"); return
		 * "logout";
		 */
	}

	// This is for edit data
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editAdmin(@ModelAttribute("command") AdminBean adminBean, BindingResult result, Model model) {
		Map<String, Object> modelmap = new HashMap<String, Object>();
		// modelmap.put("admins", );
		// modelmap.put("admin", prepareListofBean(adminService.listAdmin()));
		model.addAttribute("registerModel", prepareAdminBean(adminService.getAdminById(adminBean.getId())));
		return "register";
	}

	@ResponseBody
	@RequestMapping(value = "/verifyUsername", method = RequestMethod.GET)
	public String validateUserName(@RequestParam("username") String username) {
		boolean verifyUserName = adminService.checkUsername(username);
		if (verifyUserName) {
			return "success";
		} else {
			return "error";
		}
	}


	private com.webmodule.springmvc.model.Admin prepareModelString(AdminBean adminBean) {
		Admin admin = new Admin();
		admin.setId(adminBean.getId());
		admin.setName(adminBean.getName());
		admin.setEmail(adminBean.getEmail());
		admin.setPhone(adminBean.getPhone());
		admin.setUsername(adminBean.getUsername());
		admin.setPassword(adminBean.getPassword());
		admin.setCountry(adminBean.getCountry());
		admin.setState(adminBean.getState());
		admin.setCity(adminBean.getCity());
		admin.setArea(adminBean.getArea());
		admin.setPincode(adminBean.getPincode());
		return admin;
	}

	private Admin prepareModel(AdminBean adminBean) {
		Admin admin = new Admin();
		admin.setId(adminBean.getId());
		admin.setName(adminBean.getName());
		admin.setEmail(adminBean.getEmail());
		admin.setPhone(adminBean.getPhone());
		admin.setUsername(adminBean.getUsername());
		admin.setPassword(adminBean.getPassword());
		admin.setCountry(adminBean.getCountry());
		admin.setState(adminBean.getState());
		admin.setCity(adminBean.getCity());
		admin.setArea(adminBean.getArea());
		admin.setPincode(adminBean.getPincode());
		return admin;
	}

	private AdminBean prepareAdminBean(Admin admin) {
		AdminBean bean = new AdminBean();
		bean.setId(admin.getId());
		bean.setName(admin.getName());
		bean.setEmail(admin.getEmail());
		bean.setPhone(admin.getPhone());
		bean.setUsername(admin.getUsername());
		bean.setPassword(admin.getPassword());
		bean.setCountry(admin.getCountry());
		bean.setState(admin.getState());
		bean.setCity(bean.getCity());
		bean.setArea(bean.getArea());
		bean.setPincode(bean.getPincode());
		return bean;
	}

	private List<AdminBean> prepareListofBean(List<Admin> listAdmin) {
		List<AdminBean> beans = null;
		if (listAdmin != null && !listAdmin.isEmpty()) {
			beans = new ArrayList<AdminBean>();
			AdminBean bean = null;
			for (Admin admin : listAdmin) {
				bean = new AdminBean();
				bean.setId(admin.getId());
				bean.setName(admin.getName());
				bean.setEmail(admin.getEmail());
				bean.setPhone(admin.getPhone());
				bean.setUsername(admin.getUsername());
				bean.setPassword(admin.getPassword());
				bean.setCountry(admin.getCountry());
				bean.setState(admin.getState());
				bean.setCity(admin.getCity());
				bean.setArea(admin.getArea());
				bean.setPincode(admin.getPincode());
				beans.add(bean);
			}
		}
		return beans;
	}

}