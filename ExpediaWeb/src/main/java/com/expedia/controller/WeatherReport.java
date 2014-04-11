package com.expedia.controller;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.expedia.facade.ProcessJSONFacade;



@Controller
public class WeatherReport {
  
	/** The Constant WEATHER_URL. */
	private static final String WEATHER_URL = "weather.url";

	@Autowired
	ProcessJSONFacade processJsonFacade;
	
	/** The Constant DISPLAY_VALUES. */
	private static final String DISPLAY_VALUES = "displayValues";
	
	@RequestMapping("/")
	public String index() {
		return "weatherInfo";
	}
 
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcomeName(ModelMap model) {
 
		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - " );
		return "index";
 
	}
 
	/**
	 * This controller method returns a {@link Map}. As we have used the {@link ResponseBody} annotation,
	 * Spring tries to automatically convert the returned value into either XML or JSON (JSON by default).
	 * 
	 * The JSON conversion is done by the Jackson library (that is included in the pom.xml file).
	 */
	@RequestMapping(value="/weatherinfo/{zipCode}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,String> getWeatherInfo(@PathVariable String zipCode,HttpServletRequest request) {
		Map<String, String> weatherReportMap = getWeatherMap(zipCode, request);

		System.out.print("====="+weatherReportMap);
		if(weatherReportMap.isEmpty()) {
			weatherReportMap.put("Error", "Zip code not found");
		}
		return weatherReportMap;
	}
	
	
	
	/**
	 * Gets the weather map.
	 *
	 * @param zipCode the zip code
	 * @param request the request
	 * @return the weather map
	 */
	private Map<String, String> getWeatherMap(String zipCode,
			HttpServletRequest request) {
		final String displayValues =request.getSession().getServletContext().getInitParameter(DISPLAY_VALUES);
		final String weatherUrl =request.getSession().getServletContext().getInitParameter(WEATHER_URL);
		
		Map<String,String> weatherReportMap = processJsonFacade.getValueItemMap(zipCode, displayValues,weatherUrl);
		return weatherReportMap;
	}

}