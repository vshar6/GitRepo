package com.expedia.services.impl;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.expedia.facade.impl.ProcessJSONFacadeImpl;
import com.expedia.services.ProcessJSONService;

@Service("processJSONService")
public class ProcessJSONServiceImpl implements ProcessJSONService {

	
	/** The log. */
	org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ProcessJSONFacadeImpl.class);
	
	/** The weather map. */
	Map<String,String> weatherMap = new WeakHashMap<String, String>();
	
	/* (non-Javadoc)
	 * @see com.expedia.services.ProcessJSON#getWeatherDetails(java.util.Set, java.lang.String)
	 */
	@Override
	public Map<String, String> getWeatherDetails(final Set<String> displayItems,final String jsonString) throws JSONException {
		
		JSONObject object = new JSONObject(jsonString);

		String [] jsonObjectNameArray = JSONObject.getNames(object);
		for(String jsonName : jsonObjectNameArray) {
			processJSON(jsonName, object, displayItems);
			}
		return weatherMap;
	}
	
	
	
	
	/**
	 * Process json.
	 *
	 * @param jsonName the json name
	 * @param object the object
	 * @param itemSet the item set
	 * @return the map
	 * @throws JSONException the JSON exception
	 */
	private Map<String,String> processJSON(String jsonName,JSONObject object,Set<String> itemSet)
			throws JSONException {

		
		JSONObject newNodeJson = object.getJSONObject(jsonName);
		int i = 0;
		if(null!=newNodeJson && null!=JSONObject.getNames(newNodeJson)) {
		for(String nodeValue1 : JSONObject.getNames(newNodeJson)) {
			i++;
			
			
			
			if(itemSet.contains(nodeValue1)) {
				
				LOG.info("Condition Matched for nodeValue1"+nodeValue1);
				
				
				System.out.println(newNodeJson.getString(nodeValue1));
				weatherMap.put(nodeValue1, newNodeJson.getString(nodeValue1));
				
			}
			
			else {
				if(newNodeJson.get(nodeValue1).toString().startsWith("{")) {
					
					//JSONObject nodeJson = newNodeJson.getJSONObject(nodeValue1);
					processJSON(nodeValue1,newNodeJson, itemSet);
				}
				LOG.info("Node_"+i+"="+nodeValue1+";value_"+i+"="+newNodeJson.get(nodeValue1));
			}
		}
		
	}
		return weatherMap;

}
	
	
		
}
