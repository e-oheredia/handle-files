package com.exact.handle.files.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exact.handle.files.services.ManageFileService;

@RestController
public class ManageFileController {

	@Autowired
	private ManageFileService manageFileService;

	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	@ResponseBody
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file, @RequestParam("ruta") String ruta) {
		if (file == null) {
			ResponseEntity<String> responseEntity = new ResponseEntity<String>("-2", HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
		int respuesta = manageFileService.updateFile(file,ruta);		
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(String.valueOf(respuesta),
				HttpStatus.OK);		
		return responseEntity;

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{fileName}")
	@ResponseBody
	public ResponseEntity<Integer> upload(@PathVariable(value="fileName") String fileName) {
		if (fileName == null) {
			ResponseEntity<Integer> responseEntity = new ResponseEntity<Integer>(-2, HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
		int respuesta = manageFileService.deleteFile(fileName);		
		ResponseEntity<Integer> responseEntity = new ResponseEntity<Integer>(respuesta,
				HttpStatus.OK);		
		return responseEntity;

	}
}
