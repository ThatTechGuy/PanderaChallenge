package com.pandera.challenge.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CipherStrategyFactory {
	
	@Autowired
	private Map<String, CipherStrategy> cipherStrategyMap;
	
	public CipherStrategy getStrategy(String strategyName) {
		System.out.println(cipherStrategyMap.toString());
		return cipherStrategyMap.get(strategyName);
	}

}
