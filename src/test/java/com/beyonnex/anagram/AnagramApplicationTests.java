package com.beyonnex.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.beyonnex.anagram.service.interfaces.AnagramServiceInterface;

@SpringBootTest
class AnagramApplicationTests {
@Autowired
private AnagramServiceInterface service;
	@Test
	public void givenStrings_anagram_thenStatus200() {
		boolean resp = service.isAnagramMultiset("care", "race");
		assertEquals(true, resp);
	}
	@Test
	public void givenStrings_anagram_false_thenStatus200() {
		boolean resp = service.isAnagramMultiset("care", "races");
		assertEquals(false, resp);
	}
}
