package com.pandera.challenge.response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestShiftCipherResponse {
	
	@Test
	public void testShiftArgsConstructor() {
		ShiftCipherResponse response = new ShiftCipherResponse("cipher", "plaintext", "ciphertext", 1);
		
		assertTrue("cipher".equals(response.getCipher()));
		assertTrue("plaintext".equals(response.getPlaintext()));
		assertTrue("ciphertext".equals(response.getCiphertext()));
		assertEquals(new Integer(1), response.getShifts());
	}

}
