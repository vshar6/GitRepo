package com.expedia.facade.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expedia.connector.ProcessJSONConnector;
import com.expedia.exceptions.CustomSystemException;
import com.expedia.facade.ProcessJSONFacade;
import com.expedia.services.ProcessJSONService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessJSONFacadeImpl.
 */
@Service("processJsonFacade")
public class ProcessJSONFacadeImpl implements ProcessJSONFacade {

	
	/** The process json connector. */
	@Autowired
	ProcessJSONConnector processJSONConnector;
	
	/** The process json service. */
	@Autowired
	ProcessJSONService processJSONService;
	
	/**
	 * Gets the data to be displayed.
	 *
	 * @param dataToDisplay the data to display
	 * @return the data to be displayed
	 */
	private Set<String> getDataToBeDisplayed(final String dataToDisplay) {

		Set<String> displayItemsSet = new HashSet<String>();
		
		if (StringUtils.isNotEmpty(dataToDisplay)) {
			displayItemsSet = new HashSet<String>();
			String[] dataValues = dataToDisplay.split(",");

			for (String valueItem : dataValues) {
				displayItemsSet.add(valueItem);
			}
		}

		return displayItemsSet;
	}

	/**
	 * Gets the json string.
	 *
	 * @param zipCode the zip code
	 * @param url the url
	 * @return the json string
	 */
	private String getJsonString(final String zipCode,final String url) {
		//ProcessJSONConnectorImpl pJsonConnectorImpl = new ProcessJSONConnectorImpl();
		String jsonString = null;
		try {
			
			jsonString = processJSONConnector.getWeatherResponse(zipCode,url);
		} catch (CustomSystemException e) {
			e.printStackTrace();
		}

		return jsonString;
	}

	/* (non-Javadoc)
	 * @see com.expedia.facade.ProcessJSONFacade#getValueItemMap(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, String> getValueItemMap(final String zipCode,
			final String key,final String url) {
		Map<String, String> itemValueMap = new WeakHashMap<String, String>();
		String jsonString = getJsonString(zipCode,url);

		Set<String> configuredItemValues = getDataToBeDisplayed(key);
		//ProcessJSONServiceImpl processJSONServiceImpl = new ProcessJSONServiceImpl();
		if (configuredItemValues.size() > 0) {
			try {
				itemValueMap = processJSONService.getWeatherDetails(
						configuredItemValues, jsonString);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return itemValueMap;
	}
}
