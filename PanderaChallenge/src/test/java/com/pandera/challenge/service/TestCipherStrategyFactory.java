package com.pandera.challenge.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestCipherStrategyFactory {
	
	@InjectMocks
	private CipherStrategyFactory factory = new CipherStrategyFactory();
	
	@Mock
	private Map<String, CipherStrategy> cipherStrategyMap;
	
	@Test
	public void testGetStrategy() {
		when(cipherStrategyMap.get("caesar")).thenReturn(new CaesarCipherStrategy());
		assertThat(factory.getStrategy("caesar"), instanceOf(CaesarCipherStrategy.class));
	}

}
