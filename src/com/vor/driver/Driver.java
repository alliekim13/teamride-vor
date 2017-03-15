package com.vor.driver;
import com.vor.radio.*;
import com.vor.vorcalculator.VORCalculator;

public class Driver {
	public static void main(String[] args) {
		testRadio();
    testVORCalulator();
	}
	
	public static void testRadio() {
		RadioSignal rs = new RadioSignal();
		System.out.println(rs);
	}

	public static void testVORCalulator() {
    VORCalculator calc = new VORCalculator(new RadioSignal());
    System.out.println(calc.getSignal());
    System.out.println(calc.calculate());
  }

}
