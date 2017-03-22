package com.vor.vorcalculator;
import com.vor.radio.Signal;
import java.math.*;

public class Direction {
	private int heading;
	private int radial;
	private boolean direction; 
	
	public Direction() { //unsure on what the constructor will be like
		isTo();
	}
	
public enum Direction {
	TO, FROM;
	
	public static Direction getRandomDirection() {
		return values()[(int) (Math.random() * values().length)];
	}
}
	
	/*
	 * Parameters: int heading, int radial
	 * Method for checking which direction the aircraft is going 
	 * Returns: boolean, true if aircraft going 'to' and false if coming 'from' the station
	 * Description: calculates the to/from of the aircraft
	 * Reminder: radial always goes FROM station, so opposite of heading
	 */
	
	public boolean isTo(int heading, int radial) { 
		this.heading = heading;
		this.radial = radial;
		Direction direct; // perhaps we should use the constants? direct == Direction.TO;
		private boolean match = false;
		private int difference = radial - heading;
		
		if (radial == heading) { // heading in opposite directions
			if ((difference <= 0) && (difference >= -180) 
					|| (difference >= 0) && (difference <= 180))) { 
				match = true; // moving from the station
			}
			else {
				match = false; // moving from the station
			}
	}
		else {
			return match;
		}
		return match;
	}
}