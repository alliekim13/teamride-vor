package com.vor.vorcalculator;
import com.vor.radio.RadioSignal;

public class VORCalculator {
  private VORResult result;
  private RadioSignal signal;
  private int heading;

  public VORCalculator() {
  }

  public VORCalculator(RadioSignal signal) {
    this.signal = signal;
  }

  public VORResult getResult() {
    return result;
  }

  public void setResult(VORResult result) {
    this.result = result;
  }

  public RadioSignal getSignal() {
    return signal;
  }

  public void setSignal(RadioSignal signal) {
    this.signal = signal;
  }
  /*
  * Calculation functions
  */

  public VORResult calculate () {
    return null;
  }

  private int calculateDeflection(int heading, int radial) {
    return 0;
  }

}
