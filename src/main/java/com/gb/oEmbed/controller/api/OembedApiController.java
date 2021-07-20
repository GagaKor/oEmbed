package com.gb.oEmbed.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gb.oEmbed.service.OebService;


@RestController
public class OembedApiController {
	
	@Autowired
	private OebService service;
	
	@PostMapping(value =  "/oeb")
	@ResponseBody
	public Map<String,Object> oEmbed(@RequestBody String data) {
		data = data.replaceAll("\"", "");

		return service.getData(data);
	}
}
