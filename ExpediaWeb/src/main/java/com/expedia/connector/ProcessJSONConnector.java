package com.expedia.connector;

import com.expedia.exceptions.CustomSystemException;

public interface ProcessJSONConnector {
	
	/**
	 * Gets the weather response.
	 *
	 * @param zipCode the zip code
	 * @param url 
	 * @return the weather response
	 * @throws CustomSystemException 
	 */
	String getWeatherResponse(final String zipCode, final String url) throws CustomSystemException;

}
