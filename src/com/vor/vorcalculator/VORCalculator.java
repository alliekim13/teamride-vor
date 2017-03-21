package com.vor.vorcalculator;
import com.vor.radio.RadioSignal;
import com.vor.radio.Signal;

import java.math.*;
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

	public int calculateDeflection(int radial, int obs, boolean isTo) {
    int r = radial;
    if(isTo) {
      r = normalizeRadial(radial+180);
    }
    int angle = Math.abs(obs-r) % 360;
    angle = Math.min(angle,10);
    int deflection = angle * ((obs-r<0)? -1 : 1);
    return deflection;
  }

  public VORResult calculate(RadioSignal signal, int obs){
    int radial = signal.getRadial();
    boolean signalIsGood = (signal.getSignal() == Signal.GOOD);
    boolean isTo = isTo(radial, obs);
    VORResult result = new VORResult();
    result.setDeflection(calculateDeflection(radial, obs, isTo));
    Direction direction = ((isTo)? Direction.TO: Direction.FROM);
    result.setDirection(direction);
    Signal outSignal = (!isAbeam(radial,obs) && signalIsGood)? Signal.GOOD: Signal.BAD;
    result.setSignal(outSignal);
    return result;
  }

  public boolean isTo(int radial, int obs) {
    return false;
  }

}
