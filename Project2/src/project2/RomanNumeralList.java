package project2;


/**
 * Creating Roman Numeral List to store RomanNumeral Nodes
 * @author Ye Htut Maung
 *
 */
abstract public class RomanNumeralList {
   // set first node and last node to be dummy node and set a length to be zero
   protected RomanNumeralListNode first = new RomanNumeralListNode();
   protected RomanNumeralListNode last = first;
   protected int length = 0;
   
   /**
    * Getting length of a list
    * @return
    */
   public int getLength() {
      return length;
   }

   
   
   
}
