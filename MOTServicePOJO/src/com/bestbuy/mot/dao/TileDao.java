package com.bestbuy.mot.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


public class TileDao {
	static Logger LOG = Logger.getLogger(TileDao.class);
	
	private String serverName;
	private String databaseName;
	
	{
		serverName = "http://localhost:5984/";
		databaseName = "mot/";
	}

	
	public TileResponse findAll() throws RestClientException {
		LOG.debug("...inside findAll()");
		
		RestTemplate template = new RestTemplate();
		String url = getHost() + "_design/render/_view/view_by_version";
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		
		messageConverters.add(new FormHttpMessageConverter());
    	messageConverters.add(new StringHttpMessageConverter());
//		messageConverters.add(new MappingJacksonHttpMessageConverter());
    	MappingJacksonHttpMessageConverter jsonMessageConverter = new MappingJacksonHttpMessageConverter();
    	
    	// make sure the call does not fail due to new attributes.
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	jsonMessageConverter.setObjectMapper(objectMapper);
    	messageConverters.add(jsonMessageConverter);
		
		template.setMessageConverters(messageConverters);
		
		LOG.debug(url);
		TileResponse response =  template.getForObject(url, TileResponse.class);
		
		return response;
	}
	
	public String findAllJson() throws RestClientException {
		LOG.debug("...inside findAllJson()");
		
		RestTemplate template = new RestTemplate();
		String url = getHost() + "_design/render/_view/view_by_version";
		
		LOG.debug(url);
		String response =  template.getForObject(url, String.class);
		
		return response;
	}
	
	public String findVersionJson(String versionsId) throws RestClientException {
		LOG.debug("...inside findVersionJson()");
		
		RestTemplate template = new RestTemplate();
		String url = getHost() + "_design/render/_view/view_by_version?key=[\"" + versionsId + "\"]";
		
		LOG.debug(url);
		String response =  template.getForObject(url, String.class);
		
		return response;
	}
	
	public String getJson(String id) throws RestClientException {
		LOG.debug("...inside getJson()");
		
		RestTemplate template = new RestTemplate();
		String url = getHost() + id;
		
		LOG.debug(url);
		String response =  template.getForObject(url, String.class);
		
		return response;
	}
	
	public String save(Object tile) throws RestClientException {
		LOG.debug("...inside save()");
		
//		RestTemplate template = new RestTemplate();
//		String url = "http://localhost:5984/mot/_design/render/_view/view_by_version";
//		
//		LOG.debug(url);
//		template.p(url, tile);
		
		return null;
	}

	private String getHost() {
		return serverName + databaseName;
	}
}
