package com.webmodule.springmvc.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webmodule.springmvc.model.Admin;

@Repository("admindao")
public class AdminDaoImpl implements AdminDao {

	public AdminDaoImpl() {
		System.out.println("AdminDaoImpl call");
	}

	@Autowired
	private SessionFactory sessionFactory;

	public void addAdmin(Admin admin) {
		sessionFactory.getCurrentSession().saveOrUpdate(admin);
	}

	@SuppressWarnings("unchecked")
	public List<Admin> listAdmin() {
		return (List<Admin>) sessionFactory.getCurrentSession().createCriteria(Admin.class).list();
	}

	@Override
	public void deleteAdmin(Admin admin) {
		String deleteQuery = "DELETE FROM Admin WHERE id = " + admin.getId();
		sessionFactory.getCurrentSession().createQuery(deleteQuery).executeUpdate();
	}

	@Override
	public Admin getAdminById(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Admin where id=:id");
		query.setParameter("id", id);
		return (Admin) query.uniqueResult();
		
		/*return (Admin) sessionFactory.getCurrentSession().get(Admin.class, id);
		
		 * Session session = this.sessionFactory.getCurrentSession(); Admin admin =
		 * (Admin) session.load(Admin.class, new Integer(id)); return admin;
		 */
	}

	@Override
	public Admin findByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Admin where username=:username");
		query.setParameter("username", username);
		return (Admin) query.uniqueResult();
	}

	public boolean checkUsername(String username) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Admin.class);
		c.add(Restrictions.eq("username", username));
//		return c.list().iterator().hasNext();
		return c.list().size() > 0 ;
	}

	public boolean checkPassword(String password) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Admin.class);
		c.add(Restrictions.eq("password", password));
		System.out.println("AdminDAOImpl hasnext() is: " + c.list().iterator().hasNext());
		// Return Boolean from hasNext() method
		return c.list().iterator().hasNext();
	}

	@Override
	public void getAllStates() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * public void updateAdmin(Admin admin) { System.out.println("Coming soon.."); }
	 * 
	 * public Admin validateAdmin(Login login) { String sql =
	 * "select * from admin where username='" + login.getUsername() +
	 * "' and password='" + login.getPassword() + "'"; // List<User> users =
	 * jdbcTemplate.query(sql, new UserMapper()); List<Admin> listUsers = null;
	 * return listUsers.size() > 0 ? listUsers.get(0) : null; }
	 */

}
