package fr.cesi.ril17.spring.demo.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cesi.ril17.spring.demo.services.DemoService;
import fr.cesi.ril17.spring.demo.services.IService;
import lombok.extern.slf4j.Slf4j;

@RestController // => met automatique un @ResponseBody
@Slf4j
public class DemoController {
	
	@Autowired
	@Qualifier("DemoService")
	private IService ds;
	
	@Value("${fs.upload-dir}")
	private String uploadDir;

	
	@GetMapping(value="/demo", produces={MediaType.APPLICATION_JSON_VALUE})
	// @RequestMapping(value="/demo", method=RequestMethod.GET)
	public ResponseEntity<String> demo() {
		log.info("UPLOAD DIR {}", uploadDir);
		String jsonResult = "{\"msg\":\"message from json\"}";
		return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
	
	@GetMapping(value="/number")
	// @RequestMapping(value="/demo", method=RequestMethod.GET)
	public ResponseEntity<Integer> getNumber() {
		return new ResponseEntity<Integer>(ds.getNumber(), HttpStatus.OK);
	}

}
