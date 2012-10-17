package com.eniro.test.controllers;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eniro.test.json.Result;
import com.eniro.test.model.Search;
import com.eniro.test.model.SearchManager;

@Controller
public class SearchController {
	
	private final static Logger LOGGER = Logger.getLogger(SearchController.class.getName()); 
	
	private SearchManager searchManager;
	
	@Autowired 
	public SearchController(SearchManager searchManager) {
		this.searchManager = searchManager;
	}
	   
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public void form(Model model) {
		   model.addAttribute(new Search());
	}
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public void search(@ModelAttribute Search search, Model model) throws Exception {	
		  LOGGER.log(Level.INFO, "Search Input: " + search.getSearchValue());
		  LOGGER.log(Level.INFO, "Search Filter: " + search.getFilterValue());
		  
		  searchManager.update(search);	

		  InvokeEniroAPI invoke = new InvokeEniroAPI();	  
		  Result result = invoke.search(search.getSearchValue());
		  LOGGER.log(Level.INFO, "History Searches: " + searchManager.getAllSearches());
		  model.addAttribute("historySearches", searchManager.getAllSearches());		  		  
		  model.addAttribute(result);		
		   		  		   
	}
}
