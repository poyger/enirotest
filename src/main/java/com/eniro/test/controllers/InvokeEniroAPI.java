package com.eniro.test.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.eniro.test.json.Result;
import com.google.gson.Gson;

public class InvokeEniroAPI {
	
	private final static Logger LOGGER = Logger.getLogger(InvokeEniroAPI.class.getName()); 	
	private static String endpoint = "http://api.eniro.com/cs/search/basic?profile=Poyan&key=57079050287089208&country=se&version=1.1.3&search_word=";
	

	public Result search(String searchWord) throws Exception {		
		URL eniroApiUrl = new URL(endpoint + searchWord);		
		HttpURLConnection eniroApiConn = (HttpURLConnection) eniroApiUrl
				.openConnection();

		if (eniroApiConn == null) {
			throw new Exception(eniroApiConn +  " is null");
		}
		int respCode = eniroApiConn.getResponseCode();

		if (respCode != 200) {
			throw new Exception("reponseCode " + respCode);
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(
				eniroApiConn.getInputStream(), "UTF-8"));
		StringBuilder strResult = new StringBuilder();

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			strResult.append(inputLine);
		}
		in.close();

		Gson gson = new Gson();
		Result result = gson.fromJson(strResult.toString(), Result.class);
		
		//LOGGER.log(Level.INFO, "Search Result: " + result.toString());
		
		return result;		

	}
	
}
