package com.webmodule.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import com.webmodule.springmvc.model.Admin;
import com.webmodule.springmvc.model.Country;

public class CountryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Country> getCountryList() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Country.class);
		return (List<Country>) this.sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Admin> listAdmin() {
		return (List<Admin>) sessionFactory.getCurrentSession().createCriteria(Admin.class).list();
	}

	public boolean checkUsername(String username) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Admin.class);
		c.add(Restrictions.eq("username", username));
		// return c.list().iterator().hasNext();
		return c.list().size() > 0;
	}

}
