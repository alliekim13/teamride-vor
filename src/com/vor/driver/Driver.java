package com.vor.driver;
import com.vor.radio.*;

public class Driver {
	public static void main(String[] args) {
		testRadio();
	}
	
	public static void testRadio() {
		RadioSignal rs = new RadioSignal();
		System.out.println(rs);
	}
}
