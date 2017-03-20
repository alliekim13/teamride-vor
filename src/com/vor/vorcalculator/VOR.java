package com.vor.vorcalculator;

import com.vor.radio.RadioSignal;

public class VOR {
	private int obs;
	private RadioSignal radioSignal = new RadioSignal();
	private Direction direction;
	
	public VOR(int obsvalue, RadioSignal radiosignal, Direction direction) {
		this.obs = obsvalue;
		this.radioSignal = radiosignal;
		this.direction = direction;
	}
	
	public int getObs() {
		return this.obs;
	}
	
	public RadioSignal getRadioSignal() {
		return this.radioSignal;
	}
	
	public int getRadial() {
		return this.radioSignal.getRadial();
	}
	
	public Direction getDirection() {
		return this.direction;
	}
 
}
