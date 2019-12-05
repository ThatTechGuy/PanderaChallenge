package com.pandera.challenge.endpoint;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import com.pandera.challenge.response.CipherResponse;
import com.pandera.challenge.response.ShiftCipherResponse;
import com.pandera.challenge.service.AtbashCipherStrategy;
import com.pandera.challenge.service.CaesarCipherStrategy;
import com.pandera.challenge.service.CipherStrategyFactory;

@RunWith(MockitoJUnitRunner.class)
public class TestCipherController {
	
	@InjectMocks
	CipherController controller = new CipherController();
	
	@Mock
	CipherStrategyFactory factory;
	
	@Mock
	AtbashCipherStrategy atbash;
	
	@Mock
	CaesarCipherStrategy caesar;
	
	@Test(expected=ResponseStatusException.class)
	public void testStategyNotFoundEncipher() {
		when(factory.getStrategy("test")).thenReturn(null);
		controller.encipher("test", "plaintext", 1);
	}
	
	@Test(expected=ResponseStatusException.class)
	public void testBadShiftRequestEncipher() {
		when(factory.getStrategy("test")).thenReturn(new AtbashCipherStrategy());
		controller.encipher("test", "plaintext", 1);
	}
	
	@Test(expected=ResponseStatusException.class)
	public void testStategyNotFoundDecipher() {
		when(factory.getStrategy("test")).thenReturn(null);
		controller.decipher("test", "plaintext", 1);
	}
	
	@Test(expected=ResponseStatusException.class)
	public void testBadShiftRequestDecipher() {
		when(factory.getStrategy("test")).thenReturn(new AtbashCipherStrategy());
		controller.decipher("test", "plaintext", 1);
	}
	
	@Test
	public void testShiftResponseEncipher() {
		when(factory.getStrategy("test")).thenReturn(caesar);
		when(caesar.encipher("plaintext")).thenReturn("cipher");
		CipherResponse response = controller.encipher("test", "plaintext", 1);
		
		assertTrue("cipher".equals(response.getCiphertext()));
		assertThat(response, instanceOf(ShiftCipherResponse.class));
	}
	
	@Test
	public void testCipherResponseEncipher() {
		when(factory.getStrategy("test")).thenReturn(atbash);
		when(atbash.encipher("plaintext")).thenReturn("cipher");
		CipherResponse response = controller.encipher("test", "plaintext", null);
		
		assertTrue("cipher".equals(response.getCiphertext()));
		assertThat(response, instanceOf(CipherResponse.class));
	}
	
	@Test
	public void testShiftResponseDecipher() {
		when(factory.getStrategy("test")).thenReturn(caesar);
		when(caesar.decipher("cipher")).thenReturn("plaintext");
		CipherResponse response = controller.decipher("test", "cipher", 1);
		
		assertTrue("plaintext".equals(response.getPlaintext()));
		assertThat(response, instanceOf(ShiftCipherResponse.class));
	}
	
	@Test
	public void testCipherResponseDecipher() {
		when(factory.getStrategy("test")).thenReturn(atbash);
		when(atbash.decipher("cipher")).thenReturn("plaintext");
		CipherResponse response = controller.decipher("test", "cipher", null);
		
		assertTrue("plaintext".equals(response.getPlaintext()));
		assertThat(response, instanceOf(CipherResponse.class));
	}

}
