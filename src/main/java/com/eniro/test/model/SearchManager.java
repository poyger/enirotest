package com.eniro.test.model;

import java.util.List;

/**
 * Manages access to search information.
 */
public interface SearchManager {

	/**
	 * Get all searchs in the system
	 * @return all searchs
	 */
	public List<Search> getAllSearches();
	
	/**
	 * Takes a changed search and persists any changes made to it.
	 * @param search The search with changes
	 */
	public void update(Search search);
	
}
