package com.expedia.facade.impl;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;
import org.springframework.util.Assert;

import com.expedia.connector.impl.ProcessJSONConnectorImpl;
import com.expedia.services.impl.ProcessJSONServiceImpl;



/**
 * The class <code>ProcessJSONFacadeImplTest</code> contains tests for the class <code>{@link ProcessJSONFacadeImpl}</code>.
 *
 * @generatedBy CodePro at 4/11/14 6:27 PM
 * @author vshar6
 * @version $Revision: 1.0 $
 */
public class ProcessJSONFacadeImplTest {
	/**
	 * Run the ProcessJSONFacadeImpl() constructor test.
	 *
	 * @generatedBy CodePro at 4/11/14 6:27 PM
	 */
	
	
	@Test
	public void testProcessJSONFacadeImpl_1()
		throws Exception {
		ProcessJSONFacadeImpl result = new ProcessJSONFacadeImpl();
		assertNotNull(result);

	}

	/**
	 * Run the Map<String, String> getValueItemMap(String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/11/14 6:27 PM
	 */
	@Test
	public void testGetValueItemMapSingleValue()
		throws Exception {
		ProcessJSONFacadeImpl fixture = new ProcessJSONFacadeImpl();
		fixture.processJSONService = new ProcessJSONServiceImpl();
		fixture.processJSONConnector = new ProcessJSONConnectorImpl();
		
		String zipCode = "94117";
		String key = "temperature_string,state_name,city";
		String url = "http://api.wunderground.com/api/ed044d75b91fb500/conditions/q";

		Map<String, String> result = fixture.getValueItemMap(zipCode, key, url);

		
		assertNotNull(result);
	}
	
	/**
	 * Run the Map<String, String> getValueItemMap(String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/11/14 6:27 PM
	 */
	@Test(expected=Exception.class)
	public void testGetValueItemMap_2()
		throws Exception {
		ProcessJSONFacadeImpl fixture = new ProcessJSONFacadeImpl();
		fixture.processJSONService = new ProcessJSONServiceImpl();
		fixture.processJSONConnector = new ProcessJSONConnectorImpl();
		String zipCode = "94117";
		String key = "temperature_string,state_name,city";
		
		String url = "";

		Map<String, String> result = fixture.getValueItemMap(zipCode, key, url);
		
		Assert.notEmpty(result);

	}

	

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 4/11/14 6:27 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ProcessJSONFacadeImplTest.class);
	}
}