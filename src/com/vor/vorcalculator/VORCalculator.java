package com.vor.vorcalculator;

public class VORCalculator {
	
	private VOR vor;
	
	public VORCalculator(VOR vor) {
		this.vor = vor;
	}
	
	public boolean isAbeam() {
		int obs = vor.getObs();
		int radial = vor.getRadial();
		if (normalizeRadial(radial+90) == obs) {
			return true;
		}
		else if (normalizeRadial(radial-90) == obs) {
			return true;
		}
		else return false;
	}
	
	public boolean isAbeam(int radial, int obs) {
		if (normalizeRadial(radial+90) == obs) {
			return true;
		}
		else if (normalizeRadial(radial-90) == obs) {
			return true;
		}
		else return false;
	}
	
	public int normalizeRadial(int radial) {
		if (radial >= 360) {
			return radial%360;
		}
		else if (radial < 0) {
			return 360 + radial;
		}
		else return radial;
	}
}
