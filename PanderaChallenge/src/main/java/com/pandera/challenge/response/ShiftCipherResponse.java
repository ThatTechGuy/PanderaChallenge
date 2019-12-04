package com.pandera.challenge.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ShiftCipherResponse extends CipherResponse {
	Integer shifts;
	
	public ShiftCipherResponse(String cipher, String plaintext, String ciphertext, int shifts) {
		super(cipher, plaintext, ciphertext);
		this.shifts = shifts;
	}
}
