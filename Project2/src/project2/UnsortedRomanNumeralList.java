package project2;


/**
 * Unsorted list class with append method which add an element at the end of the list
 * @author Ye Htut Maung
 *
 */
public class UnsortedRomanNumeralList extends RomanNumeralList {
   
   /**
    * Adding a RomanNumeral at the end of the list
    * @param roman RomanNumeral A RomanNumeral to be added
     */
   public void append(RomanNumeral roman) {
      RomanNumeralListNode node = new RomanNumeralListNode(roman);
      last.next = node;
      last = node;
      length++;
   }
}
