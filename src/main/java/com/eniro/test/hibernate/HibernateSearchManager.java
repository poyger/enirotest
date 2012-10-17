package com.eniro.test.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.eniro.test.model.Search;
import com.eniro.test.model.SearchManager;

/**
 * An search manager that uses Hibernate to find searchs.
 */
@Repository
public class HibernateSearchManager implements SearchManager {

	private SessionFactory sessionFactory;

	/**
	 * Creates a new Hibernate search manager.
	 * @param sessionFactory the Hibernate session factory
	 */
	public HibernateSearchManager(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Search> getAllSearches() {
		return getCurrentSession().createQuery("from Search").list();
	}

	/**
	 * Returns the session associated with the ongoing reward transaction.
	 * @return the transactional session
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void update(Search search) {
		getCurrentSession().save(search);
		
	}
}