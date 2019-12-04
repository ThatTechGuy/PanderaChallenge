package com.pandera.challenge.service;

import org.springframework.stereotype.Component;

@Component("caesar")
public class CaesarCipherStrategy extends ShiftStrategySupport {

	@Override
	public String encipher(String plaintext) {
		String upperCase = plaintext.toUpperCase();
		StringBuilder builder = new StringBuilder();
		
		for (int i=0; i < upperCase.length(); i++) {
			int charValue = (int)upperCase.charAt(i) + shifts;
			builder.append(processChar(charValue));
		}
		
		return builder.toString();
	}

	@Override
	public String decipher(String ciphertext) {
		String upperCase = ciphertext.toUpperCase();
		StringBuilder builder = new StringBuilder();
		
		for (int i=0; i < upperCase.length(); i++) {
			int charValue = (int)upperCase.charAt(i) - shifts;
			builder.append(processChar(charValue));
		}
		
		return builder.toString();
	}
	
	private char processChar(int charValue) {
		charValue -= 65;
		
		if (charValue < 0) {
			charValue = (charValue + 26) % 26 + 65;
		} else {
			charValue = charValue % 26 + 65;
		}
		
		return (char) charValue;
	}

}
