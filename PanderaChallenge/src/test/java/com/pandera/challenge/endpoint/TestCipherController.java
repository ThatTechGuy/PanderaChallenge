package com.pandera.challenge.endpoint;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import com.pandera.challenge.service.AtbashCipherStrategy;
import com.pandera.challenge.service.CipherStrategy;
import com.pandera.challenge.service.CipherStrategyFactory;

@RunWith(MockitoJUnitRunner.class)
public class TestCipherController {
	
	@InjectMocks
	CipherController controller = new CipherController();
	
	@Mock
	CipherStrategyFactory factory;
	
	@Mock
	CipherStrategy strategy;
	
	@Test(expected=ResponseStatusException.class)
	public void testStategyNotFound() {
		when(factory.getStrategy("test")).thenReturn(null);
		controller.encipher("test", "plaintext", 1);
	}
	
	@Test(expected=ResponseStatusException.class)
	public void testBadShiftRequest() {
		when(factory.getStrategy("test")).thenReturn(new AtbashCipherStrategy());
		controller.encipher("test", "plaintext", 1);
	}

}
