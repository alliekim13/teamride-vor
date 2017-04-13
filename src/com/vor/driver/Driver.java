package com.vor.driver;
import com.vor.radio.*;
import com.vor.vorcalculator.*;

public class Driver {
	public static void main(String[] args) {
		testRadio();
    testVORCalculator(new RadioSignal(180,Signal.GOOD), 182);
    testVORCalculator(new RadioSignal(180,Signal.GOOD), 2);
    testVORCalculator(new RadioSignal(180,Signal.BAD), 182);
    testVORCalculator(new RadioSignal(180,Signal.GOOD), 90);
		testIsAbeam(0, 270);
		testIsAbeam(0, 271);
		testIsAbeam(0, 180);

		testCalculateDeflection(178, 180, false);
		testCalculateDeflection(182, 180, false);
		testCalculateDeflection(7, 178, true);
		testCalculateDeflection(10, 178, true);
		testCalculateDeflection(189, 178, true);

		testisTo(180, 360);
		testisTo(180, 180);
		testisTo(0, 360);
		testisTo(360, 0); 
	}
	
	public static void testRadio() {
		RadioSignal rs = new RadioSignal();
		System.out.println(rs);
	}

	public static void testVORCalculator(RadioSignal radioSignal, int obs) {
    System.out.println("Testing calculate With parameters");
    System.out.println("RadioSignal: "+ radioSignal);
    System.out.println("OBS: "+ obs);
    VORCalculator calc = new VORCalculator(new VOR());
    VORResult result = calc.calculate(radioSignal, obs);
    System.out.println(result);
  }

	public static void testIsAbeam(int radial, int obs) {
    System.out.println("Testing isAbeam With parameters");
    System.out.println("Radial: "+ radial);
    System.out.println("OBS: "+ obs);
    RadioSignal rs = new RadioSignal(radial, Signal.GOOD);
		VOR vor = new VOR(obs, rs, Direction.TO);
		VORCalculator vc = new VORCalculator(vor);
		boolean abeam = vc.isAbeam();
		System.out.println(abeam);
	}
	public static void testCalculateDeflection(int radial, int obs, boolean isTo) {
    System.out.println("Testing calculateDeflection With parameters");
    System.out.println("Radial: "+ radial);
    System.out.println("OBS: "+ obs);
    System.out.println("isTo: "+ isTo);

    VORCalculator vc = new VORCalculator(new VOR());
      double result = vc.calculateDeflection(radial, obs, isTo);
    System.out.println(result);
  }

  public static void testisTo(int heading, int radial) {
    VORCalculator vc = new VORCalculator(new VOR());
    boolean result = vc.isTo(heading, radial);
    System.out.println(result);
  }
 
}
