package com.expedia.connector.impl;

import java.net.URL;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expedia.connector.ProcessJSONConnector;
import com.expedia.exceptions.CustomSystemException;

@Service("processJSONConnector")
public class ProcessJSONConnectorImpl implements ProcessJSONConnector {

	/** The Constant JSON. */
	private static final String JSON = ".json";
	
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = "/";
	
	/* (non-Javadoc)
	 * @see com.expedia.connector.ProcessJSONConnector#getWeatherResponse(java.lang.String, java.lang.String)
	 */
	@Override
	public String getWeatherResponse(String zipCode, final String apiUrl)
			throws CustomSystemException {
		Scanner scan = null;

		StringBuilder jsonString = new StringBuilder();
		try {
			System.out.println("connector:" + zipCode);
			StringBuilder urlString = new StringBuilder(apiUrl);
			urlString = urlString.append(SEPARATOR).append(zipCode)
					.append(JSON);
			System.out.println("urlstr" + urlString);
			URL url = new URL(urlString.toString());
			scan = new Scanner(url.openStream());
			jsonString = new StringBuilder();
			while (scan.hasNext()) {
				jsonString.append(scan.nextLine());
			}

		} catch (Exception e) {
			throw new CustomSystemException("Exception in getting response", e);
		} finally {
			if (scan != null)
				scan.close();
		}
		return jsonString.toString();

	}

}
