package com.eniro.test.backend;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

import com.eniro.test.json.Result;
import com.google.gson.Gson;

public class InvokeEniroAPICallable implements Callable<Result> {

	private final static Logger LOGGER = Logger
			.getLogger(InvokeEniroAPICallable.class.getName());

	private final static String ENDPOINT = "http://api.eniro.com/cs/search/basic?profile=Poyan&key=57079050287089208&country=se&version=1.1.3&search_word=";

	private final static int CONNECTION_TIMEOUT = 5000;
	private final static int READ_TIMEOUT = 10000;

	private String searchWord;

	public InvokeEniroAPICallable(String searchWord) {
		this.searchWord = searchWord;
	}

	@Override
	public Result call() throws Exception {
		URL eniroApiUrl = new URL(ENDPOINT + searchWord);
		HttpURLConnection eniroApiConn = (HttpURLConnection) eniroApiUrl
				.openConnection();
		if (eniroApiConn == null) {
			throw new Exception(eniroApiConn + " is null");
		}
		eniroApiConn.setConnectTimeout(CONNECTION_TIMEOUT);
		eniroApiConn.setReadTimeout(READ_TIMEOUT);

		int respCode = eniroApiConn.getResponseCode();

		if (respCode != 200) {
			throw new Exception("reponseCode " + respCode);
		}
		Gson gson = new Gson();
		Result result = gson.fromJson(
				new InputStreamReader(eniroApiConn.getInputStream(), "UTF-8"),
				Result.class);

		// LOGGER.log(Level.INFO, "Search Result: " + result.toString());

		return result;
	}

}
