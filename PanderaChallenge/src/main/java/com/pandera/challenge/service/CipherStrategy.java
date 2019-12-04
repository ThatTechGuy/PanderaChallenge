package com.pandera.challenge.service;

public interface CipherStrategy {
	
	public String encipher(String plaintext);
	
	public String decipher(String ciphertext);

}
