package project4;
import java.util.HashMap;
import java.util.regex.*;
/**
 * RomanNumeral class to store RomanNumeral and converted to arabic numbers
 * 
 * @author Ye Htut Maung
 *
 */

public class RomanNumeral {
   // to store roman numeral string
   private String romanNumeral;
   // to store converted roman numeral in arabic number
   private int arabicValue;

   /**
    * Constructor - Converting roman numeral to arabic number
    */
   
 
   public RomanNumeral(String roman) {
      romanNumeral = roman;
      
      
      if (RomanNumeralMatcher(romanNumeral)) {
         arabicValue = calculateRomToInt(romanNumeral);
      } else {
         throw new IllegalRomanNumeralException( romanNumeral + " is bad Roman");
      }
      // converting roman numeral and assign to arabic value
            
   }
   protected static boolean RomanNumeralMatcher (String roman) {
      Pattern p;
      Matcher m;
      String ROMAN_PATTERN = "[MDCLXIV]+";
      p = Pattern.compile(ROMAN_PATTERN);
      m = p.matcher(roman);
      return m.matches();
   }


   /**
    * Converte roman numeral to arabic value
    * 
    * @param roman Sting The roman numeral to be converted to Arabic numeral
    * @return integer The arabic numeral converted from the Roman numeral
    */
   private int calculateRomToInt(String roman) {
      if (roman == null || roman.length() == 0) {
         throw new IllegalRomanNumeralException( roman + " is bad Roman");
      }
      
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      map.put('I', 1);
      map.put('V', 5);
      map.put('X', 10);
      map.put('L', 50);
      map.put('C', 100);
      map.put('D', 500);
      map.put('M', 1000);
      
      int len = roman.length(), result = map.get(roman.charAt(len - 1));
      
      for (int i = len - 2; i >= 0; i--) {
         if (map.get(roman.charAt(i)) >= map.get(roman.charAt(i + 1)))
             result += map.get(roman.charAt(i));
         else
             result -= map.get(roman.charAt(i));
     }
     return result;
   }

   /**
    * Get roman numeral
    * 
    * @return String romanNumeral
    */
   public String getRomanNumeral() {
      return romanNumeral;
   }

   /**
    * Set new romanNumeral and converted to arabic number
    * 
    * @param roman String Roman Numeral
    */
   public void setRomanNumeral(String roman) {
      romanNumeral = roman;
      arabicValue = calculateRomToInt(romanNumeral);
   }

   /**
    * Get arabic number
    * 
    * @return integer Arabic number
    */
   public int getArabicValue() {
      return arabicValue;
   }

   /**
    * Checking if two roman numeral are equal or not
    * 
    * @return true if two roman numeral are equal else false
    */
   public boolean equals(Object other) {
      return other != null && this.getClass() == other.getClass()
            && this.getArabicValue() == ((RomanNumeral) other).getArabicValue()
            && this.getRomanNumeral().equals(((RomanNumeral) other).getRomanNumeral());
   }

   /**
    * Show roman numeral in string of arabic number
    * 
    * @return String arabic number
    */
   public String toString() {
      return "Arabic Value of " + getRomanNumeral() + " is " + getArabicValue();
   }

   /**
    * Compare two roman numeral
    * 
    * @param other
    * @return zero if two roman numeral are equal positive number if the first
    *         roman numeral is larger negative number if the first roman numeral is
    *         smaller
    */
   public int compareTo(RomanNumeral other) {
      return this.getArabicValue() - other.getArabicValue();
   }

}
