package com.vor.driver;
import com.vor.radio.*;
import com.vor.vorcalculator.*;

public class Driver {
	public static void main(String[] args) {
		testRadio();
		testIsAbeam(0, 270);
	}
	
	public static void testRadio() {
		RadioSignal rs = new RadioSignal();
		System.out.println(rs);
	}
	
	public static void testIsAbeam(int radial, int obs) {
		RadioSignal rs = new RadioSignal(radial, Signal.GOOD);
		VOR vor = new VOR(obs, rs, Direction.TO);
		VORCalculator vc = new VORCalculator(vor);
		boolean abeam = vc.isAbeam();
		System.out.println(abeam);
	}
}
