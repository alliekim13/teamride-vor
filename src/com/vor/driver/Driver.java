package com.vor.driver;
import com.vor.radio.*;
import com.vor.vorcalculator.VOR;

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
    VOR calc = new VOR();
  }

}
