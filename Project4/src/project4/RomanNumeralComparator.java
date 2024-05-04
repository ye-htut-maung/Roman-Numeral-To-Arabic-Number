package project4;

import java.util.*;

/**
 * Comparator class for RomanNumeral    
 * @author yehtu
 *
 */

public class RomanNumeralComparator implements Comparator <RomanNumeral> {
   public int compare(RomanNumeral num1, RomanNumeral num2) {
      return num1.compareTo(num2);
   }
}
