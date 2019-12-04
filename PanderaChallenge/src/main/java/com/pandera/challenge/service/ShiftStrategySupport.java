package com.pandera.challenge.service;

public abstract class ShiftStrategySupport implements CipherStrategy {
	
	protected int shifts = 0;
	
	public void setShifts(int shifts) {
		this.shifts = shifts;
	}

}
