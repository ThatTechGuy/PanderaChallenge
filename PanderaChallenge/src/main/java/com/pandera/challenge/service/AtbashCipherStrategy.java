package com.pandera.challenge.service;

import org.springframework.stereotype.Component;

@Component("atbash")
public class AtbashCipherStrategy implements CipherStrategy {

	@Override
	public String encipher(String plaintext) {
		String upperCase = plaintext.toUpperCase();
		StringBuilder builder = new StringBuilder();
		
		for (char c : upperCase.toCharArray()) {
			builder.append((char) ('A' + ('Z' - c)));
		}
		
		return builder.toString();
	}

	@Override
	public String decipher(String ciphertext) {
		String upperCase = ciphertext.toUpperCase();
		StringBuilder builder = new StringBuilder();
		
		for (char c : upperCase.toCharArray()) {
			builder.append((char) ('Z' + ('A' - c)));
		}
		
		return builder.toString();
	}

}
