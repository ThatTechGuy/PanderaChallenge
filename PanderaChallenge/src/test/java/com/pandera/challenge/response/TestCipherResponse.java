package com.pandera.challenge.response;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestCipherResponse {
	
	@Test
	public void testAllArgsConstructor() {
		CipherResponse response = new CipherResponse("cipher", "plaintext", "ciphertext");
		
		assertTrue("cipher".equals(response.getCipher()));
		assertTrue("plaintext".equals(response.getPlaintext()));
		assertTrue("ciphertext".equals(response.getCiphertext()));
	}
	
	@Test
	public void testNoArgsConstructor() {
		CipherResponse response = new CipherResponse();
		
		assertNull(response.getCipher());
		assertNull(response.getPlaintext());
		assertNull(response.getCiphertext());
	}

}
