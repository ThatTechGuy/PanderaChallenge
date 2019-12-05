package com.pandera.challenge.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestCaesarCipherStrategy {
	private static final String PLAINTEXT = "THEXQUICKXBROWNXFOXXJUMPSXOVERXTHEXLAZYXDOG";
	private static final String CIPHERTEXT = "QEBUNRFZHUYOLTKUCLUUGRJMPULSBOUQEBUIXWVUALD";
	
	private ShiftStrategySupport cipher = new CaesarCipherStrategy();
	
	@Before
	public void setUp() {
		cipher.setShifts(-3);
	}
	
	@Test
	public void testEncipher() {		
		assertTrue(CIPHERTEXT.equals(cipher.encipher(PLAINTEXT)));
	}
	
	@Test
	public void testDecipher() {
		assertTrue(PLAINTEXT.equals(cipher.decipher(CIPHERTEXT)));
	}
	
	@Test
	public void testCipherZeroShifts() {
		cipher.setShifts(0);
		assertTrue(PLAINTEXT.equals(cipher.encipher(PLAINTEXT)));
	}

}
