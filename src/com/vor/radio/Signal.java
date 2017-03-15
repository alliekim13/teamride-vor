package com.vor.radio;

public enum Signal {
	GOOD, BAD;
	
	public static Signal getRandomSignal() {
		return values()[(int) (Math.random() * values().length)];
	}
}
