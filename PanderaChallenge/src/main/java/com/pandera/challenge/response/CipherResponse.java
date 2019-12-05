package com.pandera.challenge.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CipherResponse {
	private String cipher;
	private String plaintext;
	private String ciphertext;
}
