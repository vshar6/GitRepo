package com.expedia.services;

import java.util.Map;
import java.util.Set;

import org.json.JSONException;

public interface ProcessJSONService {

	
	
	/**
	 * Gets the weather details.
	 *
	 * @param displayItems the display items
	 * @param jsonString the json string
	 * @return the weather details
	 * @throws JSONException 
	 */
	Map<String, String> getWeatherDetails(Set<String> displayItems,
			String jsonString) throws JSONException;
	
}
