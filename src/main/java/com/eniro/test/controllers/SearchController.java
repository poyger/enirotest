package com.eniro.test.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eniro.test.backend.InvokeEniroAPICallable;
import com.eniro.test.json.Result;
import com.eniro.test.model.Search;
import com.eniro.test.model.SearchManager;

@Controller
public class SearchController {

	private final static Logger LOGGER = Logger
			.getLogger(SearchController.class.getName());

	private SearchManager searchManager;

	@Autowired
	public SearchController(SearchManager searchManager) {
		this.searchManager = searchManager;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public void form(Model model) {
		model.addAttribute(new Search());
		LOGGER.log(Level.INFO,
				"History Searches: " + searchManager.getAllSearches());
		model.addAttribute("historySearches", searchManager.getAllSearches());
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public void search(@ModelAttribute Search search, Model model)
			throws Exception {
		LOGGER.log(Level.INFO, "Search Input: " + search.getSearchValue());
		LOGGER.log(Level.INFO, "Search Filter: " + search.getFilterValue());

		searchManager.update(search);		
		String[] searchWordArray  = search.getSearchValue().split(",");
		
		ExecutorService executor = Executors.newCachedThreadPool();
		List<Future<Result>> list = new ArrayList<Future<Result>>();
		for (int i = 0; i < searchWordArray.length; i++) {
			Callable<Result> worker = new InvokeEniroAPICallable(searchWordArray[i]);
			Future<Result> submit = executor.submit(worker);
			list.add(submit);
		}
		ArrayList<Result> resultList = new ArrayList<Result>();
		System.out.println(list.size());
		// Now retrieve the result
		for (Future<Result> future : list) {
			try {
				resultList.add(future.get());	
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
		model.addAttribute(resultList.get(1));
	}
}