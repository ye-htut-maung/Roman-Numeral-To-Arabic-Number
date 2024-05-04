package project2;

/**
 * RomanNumeral class to store RomanNumeral and converted to arabic numbers
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
      // converting roman numeral and assign to arabic value
      arabicValue = calculateRomToInt(romanNumeral);
   }

   /**
    * Converte roman numeral to arabic value
    * 
    * @param roman Sting The roman numeral to be converted to Arabic numeral
    * @return integer The arabic numeral converted from the Roman numeral
    */
   private int calculateRomToInt(String roman) {
      int total = 0;

      // calculate Arabic numeral from Roman numeral
      for (int i = 0; i < roman.length(); i++) {
         switch (roman.charAt(i)) {
         case 'M':
            total += 1000;
            if (i != 0 && roman.charAt(i - 1) == 'C') {
               total -= 200;
            }
            break;
         case 'D':
            total += 500;
            if (i != 0 && roman.charAt(i - 1) == 'C') {
               total -= 200;
            }
            break;
         case 'C':
            total += 100;
            if (i != 0 && roman.charAt(i - 1) == 'X') {
               total -= 20;
            }
            break;
         case 'L':
            total += 50;
            if (i != 0 && roman.charAt(i - 1) == 'X') {
               total -= 20;
            }
            break;
         case 'X':
            total += 10;
            if (i != 0 && roman.charAt(i - 1) == 'I') {
               total -= 2;
            }
            break;
         case 'V':
            total += 5;
            if (i != 0 && roman.charAt(i - 1) == 'I') {
               total -= 2;
            }
            break;
         case 'I':
            total += 1;
            break;
         }
      }

      return total;
   }

   
   /**
    * Get roman numeral
    * @return String romanNumeral
    */
   public String getRomanNumeral() {
      return romanNumeral;
   }
   
   /**
    * Set new romanNumeral and converted to arabic number
    * @param roman String Roman Numeral
    */
   public void setRomanNumeral(String roman) {
      romanNumeral = roman;
      arabicValue = calculateRomToInt(romanNumeral);
   }

   /**
    * Get arabic number  
    * @return integer Arabic number
    */
   public int getArabicValue() {
      return arabicValue;
   }

   
   /**
    * Checking if two roman numeral are equal or not
    * @return true if two roman numeral are equal else false
    */
   public boolean equals(Object other) {
      return other != null && this.getClass() == other.getClass()
            && this.getArabicValue() == ((RomanNumeral) other).getArabicValue()
            && this.getRomanNumeral().equals(((RomanNumeral) other).getRomanNumeral());
   }
   
   /**
    * Show roman numeral in string of arabic number
    * @return String arabic number
    */
   public String toString() {
      return "Arabic Value of " + getRomanNumeral() + " is " + getArabicValue();
   }
   
   /**
    * Compare two roman numeral
    * 
    * @param other
    * @return zero if two roman numeral are equal
    *         positive number if the first roman numeral is larger
    *         negative number if the first roman numeral is smaller
    */
   public int compareTo(RomanNumeral other) {
      return this.getArabicValue() - other.getArabicValue();
   }
   
  
}
