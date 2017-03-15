package com.vor.vorcalculator;
import com.vor.radio.RadioSignal;

public class VORCalculator {
  private VORResult result;
  private int heading;

  public VORCalculator() {
  }

  public VORCalculator(int heading) {
    this.heading = heading;
  }

  public int getHeading() {
    return heading;
  }

  public void setHeading(int heading) {
    this.heading = heading;
  }

  public VORResult getResult() {
    return result;
  }

  public void setResult(VORResult result) {
    this.result = result;
  }

  /*
  * Calculation functions
  */

  public VORResult calculate (RadioSignal signal) {
    return null;
  }

  private int calculateDeflection(int heading, int radial) {
    return 0;
  }

}
