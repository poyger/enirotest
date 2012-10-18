package com.eniro.test.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	private ExecutorService executorService;
	
	@Autowired
	public SearchController(SearchManager searchManager, ExecutorService executorService) {
		this.searchManager = searchManager;
        this.executorService = executorService;
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
		final String[] searchWordArray  = search.getSearchValue().split(",");
		
		final List<Future<Result>> list = new ArrayList<Future<Result>>();
		for (int i = 0; i < searchWordArray.length; i++) {
			Callable<Result> worker = new InvokeEniroAPICallable(searchWordArray[i]);
			Future<Result> submit = executorService.submit(worker);
			list.add(submit);
		}
		// Now retrieve the result
		ArrayList<Result> resultList = new ArrayList<Result>();
		for (Future<Result> future : list) {
			try {
				resultList.add(future.get());	
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		// Do Filtering on the result list
		if(search.getFilterValue() != null && !search.getFilterValue().equals(""))
		resultList = filter(resultList, search.getFilterValue());	
		
		model.addAttribute("resultList",resultList);
	}
	
	private ArrayList<Result> filter(final ArrayList<Result> resultList, final String filterValue){
		final Pattern pattern = Pattern.compile(filterValue , Pattern.CASE_INSENSITIVE);
		if(resultList != null){
			int filter_count = 0;
			for(Result result : resultList){
				for(int i = 0; i < result.getAdverts().size(); i++){
				    Matcher matcher = pattern.matcher(result.getAdverts().get(i).toString());				    
				    if(matcher.matches()){
				    	result.getAdverts().remove(i);				    	
				    	filter_count++;
				    }
				}	
			}		
			LOGGER.log(Level.INFO, "Filter count: " + filter_count);
		}
		
		return resultList;		
	}	
}