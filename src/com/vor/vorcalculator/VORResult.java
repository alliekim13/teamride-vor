package com.vor.vorcalculator;

public class VORResult {
	private int deflection;
	Direction direction;
	Signal signal;
	
	public int getDeflection() {
		return deflection;
	}
	
	public Signal getSignal() {
		return signal;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDeflection(int d) {
		deflection=d;
	}
	
	public void setSignal(Signal s) {
		signal=s;
	}
	
	public void setDirection(Direction dir) {
		direction = dir;
	}
}
