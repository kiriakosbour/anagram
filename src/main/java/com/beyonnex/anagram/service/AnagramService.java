package com.beyonnex.anagram.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.beyonnex.anagram.controller.AnagramController;
import com.beyonnex.anagram.service.interfaces.AnagramServiceInterface;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

@Service
public class AnagramService implements AnagramServiceInterface {
	private static final Logger LOG = LoggerFactory.getLogger(AnagramService.class);
	private String preprocess(String source) {
		return source.replaceAll("[^a-zA-Z]", "").toLowerCase();
	}

	@Override
	public boolean isAnagramMultiset(String string1, String string2) {
		string1 = preprocess(string1);
		string2 = preprocess(string2);
		LOG.info("Checking anagram for String "+string1+" and String "+string2+" after removing non letter chars");
		if (string1.length() != string2.length()) {
			return false;
		}
		Multiset<Character> multiset1 = HashMultiset.create();
		Multiset<Character> multiset2 = HashMultiset.create();
		for (int i = 0; i < string1.length(); i++) {
			multiset1.add(string1.charAt(i));
			multiset2.add(string2.charAt(i));
		}
		return multiset1.equals(multiset2);
	}
}