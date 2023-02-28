package com.beyonnex.anagram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.beyonnex.anagram.service.interfaces.AnagramServiceInterface;
import com.google.common.base.Strings;

@RestController
public class AnagramController {
	@Autowired
	AnagramServiceInterface service;
	private static final Logger LOG = LoggerFactory.getLogger(AnagramController.class);
	@GetMapping("/anagram/compare/{string1}/{string2}")
	public String findAll(@PathVariable("string1") String string1,@PathVariable("string2")String string2 ) {
		if(Strings.isNullOrEmpty(string1)||Strings.isNullOrEmpty(string2)) {
			return HttpStatus.BAD_REQUEST.toString();
		}
		LOG.info("Ready to compare strings for anagram");
		boolean resp = service.isAnagramMultiset(string1, string2);
		return HttpStatus.OK.toString() + "The result of the anagram check is "+ resp ;
	}
}
