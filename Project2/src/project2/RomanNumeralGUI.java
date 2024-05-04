package project2;

import javax.swing.*;
import java.awt.*;

/**
 * The GUI of Roman numeral to Arabic numeral
 * 
 * @author Ye Htut Maung
 *
 */

public class RomanNumeralGUI extends JFrame {
   
   private static Container myContentPane;
   private static TextArea myOriginalRoman;
   private static TextArea unsortedNumbers;
   private static TextArea sortedNumbers;

   /**
    * Constructor - Creating a User Interface
    */

   public RomanNumeralGUI(UnsortedRomanNumeralList unsortedList, SortedRomanNumeralList sortedList) {
      setSize(600, 400);
      setLocation(100, 100);
      setTitle("Roman Numeral");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
      
      setLayout(new GridLayout(1, 3));
      myContentPane = getContentPane();
      myOriginalRoman = new TextArea();
      unsortedNumbers = new TextArea();
      sortedNumbers = new TextArea();
      myOriginalRoman.setEditable(false);
      unsortedNumbers.setEditable(false);
      sortedNumbers.setEditable(false);
      myContentPane.add(myOriginalRoman);
      myContentPane.add(unsortedNumbers);
      myContentPane.add(sortedNumbers);
      
      printRomanANumeral(unsortedList, sortedList);
   }

   /**
    * Print three columns: one column with individual unsorted Roman numeral, one
    * column with corresponding unsorted Arabic numbers and one column with sorted
    * numbers
    * 
    * @param unsortedList
    * @param sortedList
    */

   private void printRomanANumeral(UnsortedRomanNumeralList unsortedList, SortedRomanNumeralList sortedList) {
      
      
      // pointer node of unsorted list
      RomanNumeralListNode unsortedPointer = unsortedList.first.next;
      
      // adding unsorted roman numeral and arabic numbers to GUI
      while (unsortedPointer != null) {
         myOriginalRoman.append(unsortedPointer.data.getRomanNumeral() + "\n");
         unsortedNumbers.append(unsortedPointer.data.getArabicValue() + "\n");
         unsortedPointer = unsortedPointer.next;
      }
      
      // pointer node of sorted list
      RomanNumeralListNode sortedPointer = sortedList.first.next;
      
      // adding sorted arabic numbers to GUI
      while (sortedPointer != null) {
         sortedNumbers.append(sortedPointer.data.getArabicValue() + "\n");
         sortedPointer = sortedPointer.next;
      }

   }
}
