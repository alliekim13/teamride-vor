package com.vor.driver;
import com.vor.radio.*;
import com.vor.vorcalculator.VORCalculator;

public class Driver {
	public static void main(String[] args) {
		testRadio();
    testVORCalculator();
	}
	
	public static void testRadio() {
		RadioSignal rs = new RadioSignal();
		System.out.println(rs);
	}

	public static void testVORCalculator() {
    VORCalculator calc = new VORCalculator();
  }

}
