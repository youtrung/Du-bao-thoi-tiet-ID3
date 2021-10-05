/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author trung
 */
public class Ifthenrule {
  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = Ifthenrule.N3cf0a44d0(i);
    return p;
  }
  static double N3cf0a44d0(Object []i) {
    double p = Double.NaN;
    if (i[0] == null) {
      p = 1;
    } else if (((Double) i[0]).doubleValue() <= 47.5) {
    p = Ifthenrule.Nf2d0e0f1(i);
    } else if (((Double) i[0]).doubleValue() > 47.5) {
    p = Ifthenrule.N77c1d1293(i);
    } 
    return p;
  }
  static double Nf2d0e0f1(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 2;
    } else if (((Double) i[5]).doubleValue() <= 74.7) {
    p = Ifthenrule.N17ebaf7a2(i);
    } else if (((Double) i[5]).doubleValue() > 74.7) {
      p = 1;
    } 
    return p;
  }
  static double N17ebaf7a2(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 0;
    } else if (((Double) i[5]).doubleValue() <= 24.7) {
      p = 0;
    } else if (((Double) i[5]).doubleValue() > 24.7) {
      p = 2;
    } 
    return p;
  }
  static double N77c1d1293(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 4;
    } else if (((Double) i[5]).doubleValue() <= 75.0) {
      p = 4;
    } else if (((Double) i[5]).doubleValue() > 75.0) {
      p = 3;
    } 
    return p;
  }
}

