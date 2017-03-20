package com.vor.vorcalculator;

public enum Direction {
	TO, FROM;
	
	public static Direction getRandomDirection() {
		return values()[(int) (Math.random() * values().length)];
	}
}
