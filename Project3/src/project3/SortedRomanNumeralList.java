package project3;

/**
 * Sorted RomanNumeral List with add method which will add in order in the list
 * @author Ye Htut Maung
 *
 */
public class SortedRomanNumeralList extends RomanNumeralList {
   
   /**
    * Adding RomanNumeral to sorted linked list (smallest to largest)
    * @param roman RomanNumeral A RomanNumeral to be added in order
    */
   public void add (RomanNumeral roman) {
      RomanNumeralListNode node = new RomanNumeralListNode(roman);
      RomanNumeralListNode pointer = first;

         while (true) {
            if (pointer.next != null && node.data.compareTo(pointer.next.data) <= 0 ) {
               node.next = pointer.next;
               pointer.next = node;
               length++;
               break;
            } else if (pointer.next == null) {
               
               last.next = node;
               last = node;
               length++;
               break;
            } else {
               pointer = pointer.next;
            }
         }
      
      
      
   }

}
