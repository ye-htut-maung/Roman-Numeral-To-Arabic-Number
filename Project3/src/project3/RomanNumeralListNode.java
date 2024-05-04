package project3;

/**
 * Creating a note that roman numeral object will be used
 * @author Ye Htut Maung
 *
 */
public class RomanNumeralListNode {
   
   // To store RomanuNmeral object
   protected RomanNumeral data;
   // To store the reference of next node
   protected RomanNumeralListNode next;
   
   /**
    * Default constructor - set data and next to be null
    */
   public RomanNumeralListNode (){
      data = null;
      next = null;
   }
   
   /**
    * Constructor with RomanNumeral param - set the data to RomanNumeral from the parameter
    * @param d RomanNumeral
    */
   public RomanNumeralListNode(RomanNumeral d) {
      data = d;
      next = null;
   }

}
