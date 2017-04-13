package com.vor.driver;
import com.vor.radio.*;
import com.vor.vorcalculator.*;

public class Driver {
	public static void main(String[] args) {
		testRadio();
    testVORCalculator();
		testIsAbeam(0, 270);
		testCalculateDeflection(178, 180, false);
		testCalculateDeflection(182, 180, false);
		testCalculateDeflection(7, 178, true);
		
		testisTo(180, 360);
	}
	
	public static void testRadio() {
		RadioSignal rs = new RadioSignal();
		System.out.println(rs);
	}

	public static void testVORCalculator() {
    RadioSignal rs = new RadioSignal(178, Signal.GOOD);
    VORCalculator calc = new VORCalculator(new VOR());
    VORResult result = calc.calculate(rs, 180);
    System.out.println(result);
  }

	public static void testIsAbeam(int radial, int obs) {
		RadioSignal rs = new RadioSignal(radial, Signal.GOOD);
		VOR vor = new VOR(obs, rs, Direction.TO);
		VORCalculator vc = new VORCalculator(vor);
		boolean abeam = vc.isAbeam();
		System.out.println(abeam);
	}
	public static void testCalculateDeflection(int radial, int obs, boolean isTo) {
    VORCalculator vc = new VORCalculator(new VOR());
      double result = vc.calculateDeflection(radial, obs, isTo);
    System.out.println(result);
  }

  public static boolean testisTo(int heading, int radial) {
    VORCalculator vc = new VORCalculator(new VOR());
    boolean result = vc.isTo(heading, radial);
    return result;
  }
 
}
