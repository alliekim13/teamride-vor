package com.vor.radio;
import java.util.Random;

public class RadioSignal {
	private int radial;
	private Signal signal;
	
	public RadioSignal() {
		generateRadial();
		generateSignal();
	}
	
	public RadioSignal(int r, Signal s) {
		this.radial = r;
		this.signal = s;
	}
	
	private void generateRadial() {
		Random rand = new Random();
		this.radial = rand.nextInt(359);
	}

	private void generateSignal() {
		this.signal = Signal.getRandomSignal();
	}
	
	public Signal getSignal() {
		return signal;
	}
	
	public int getRadial() {
		return radial;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "[signal=" + signal + ", radial=" + radial + "]";
	}
}
