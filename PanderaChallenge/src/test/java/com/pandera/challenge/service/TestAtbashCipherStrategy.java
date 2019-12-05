package com.pandera.challenge.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAtbashCipherStrategy {
	private static final String PLAINTEXT = "THEXQUICKXBROWNXFOXXJUMPSXOVERXTHEXLAZYXDOG";
	private static final String CIPHERTEXT = "GSVCJFRXPCYILDMCULCCQFNKHCLEVICGSVCOZABCWLT";
	
	CipherStrategy cipher = new AtbashCipherStrategy();

	@Test
	public void testEncipher() {		
		assertTrue(CIPHERTEXT.equals(cipher.encipher(PLAINTEXT)));
	}
	
	@Test
	public void testDecipher() {
		assertTrue(PLAINTEXT.equals(cipher.decipher(CIPHERTEXT)));
	}

}
