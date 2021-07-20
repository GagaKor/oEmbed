package com.gb.oEmbed.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OebService {
	
	private String check(String url) {
		String rs = "";
		if(url.contains("www.youtube.com")) {
			rs = "https://www.youtube.com/oembed?url="+url;
		}else if(url.contains("www.instagram.com")){
			rs = "https://api.instagram.com/oembed?url="+url;
		}else if(url.contains("twitter.com")){
			rs = "https://publish.twitter.com/oembed?url="+url;
		}else if(url.contains("vimeo.com")){
			rs = "https://vimeo.com/api/oembed.json?url="+url;
		}
		return rs;
	}

	public Map<String,Object> getData(String data) {
		
		
		Map<String, Object> embedResult = new HashMap<>();
		Map<String, Object> result = new HashMap<>();

			RestTemplate rt = new RestTemplate();

			try {
				String embedRes = rt.getForObject(check(data), String.class);
				ObjectMapper objMapper = new  ObjectMapper();
				embedResult = objMapper.readValue(embedRes, new TypeReference<Map<String, Object>>() {});
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(RestClientException e) {
				e.printStackTrace();
				System.out.println("잘못된 요청입니다.");
			}
			result.put("res", embedResult);
			
			return result;
	}
}



	
	
