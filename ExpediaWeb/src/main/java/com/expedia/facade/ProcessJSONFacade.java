package com.expedia.facade;

import java.util.Map;

public interface ProcessJSONFacade {

	
	/**
	 * Gets the value item map.
	 *
	 * @param jsonString the json string
	 * @return the value item map
	 */
	Map<String, String> getValueItemMap(final String zipCode,final String key,final String weatherUrl);
	
	

}
