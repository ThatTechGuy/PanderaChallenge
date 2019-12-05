package com.pandera.challenge.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pandera.challenge.response.CipherResponse;
import com.pandera.challenge.response.ShiftCipherResponse;
import com.pandera.challenge.service.CipherStrategy;
import com.pandera.challenge.service.CipherStrategyFactory;
import com.pandera.challenge.service.ShiftStrategySupport;

@RestController
public class CipherController {
	
	@Autowired
	CipherStrategyFactory strategyFactory;
	
	@PostMapping("/{cipher}/encipher")
	public CipherResponse encipher(
			@PathVariable String cipher,
			@RequestParam(value="plaintext") String plaintext, 
			@RequestParam(value="shifts", required=false) Integer shifts) {
		
		CipherStrategy cs = getStrategy(cipher);
		CipherResponse response;
		
		if (shifts != null) {
			shiftProcessing(cs, shifts);
			
			response = new ShiftCipherResponse(cipher, plaintext, cs.encipher(plaintext), shifts);
		} else {
			response = new CipherResponse(cipher, plaintext, cs.encipher(plaintext));
		}
		
		return response;
	}
	
	@PostMapping("/{cipher}/decipher")
	public CipherResponse decipher(
			@PathVariable String cipher,
			@RequestParam(value="ciphertext") String ciphertext,
			@RequestParam(value="shifts", defaultValue="0") int shifts) {
		
		CipherStrategy cs = getStrategy(cipher);
		CipherResponse response;
		
		if (shifts != 0) {
			shiftProcessing(cs, shifts);
			
			response = new ShiftCipherResponse(cipher, cs.decipher(ciphertext), ciphertext, shifts);
		} else {
			response = new CipherResponse(cipher, cs.decipher(ciphertext), ciphertext);
		}
		
		return response;
	}
	
	private CipherStrategy getStrategy(String cipher) {
		CipherStrategy cs = strategyFactory.getStrategy(cipher);
		
		if (cs == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return cs;
	}
	
	private void shiftProcessing(CipherStrategy cs, int shifts) {
		try {
			ShiftStrategySupport shiftStrategy = (ShiftStrategySupport) cs;
			shiftStrategy.setShifts(shifts);
		} catch (ClassCastException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

}
