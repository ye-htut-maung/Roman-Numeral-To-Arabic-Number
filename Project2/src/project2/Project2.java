package project2;

import java.util.*;

/**
 * A program that converts from Roman numerals to Arabic numeral using GUI. In
 * GUI, There are three columns. First one shows the unsorted Roman numeral.
 * Second one shows the unsorted Arabic numeral. Third one shows the sorted
 * Arabic numeral.
 * 
 * @author Ye Htut Maung
 *
 */

public class Project2 {

   public static void main(String[] args) {

      // getting file from command line argument
      String fileName = args[0];

      // Creating an unsorted list
      UnsortedRomanNumeralList unsortedList = new UnsortedRomanNumeralList();
      // Creating a sorted list
      SortedRomanNumeralList sortedList = new SortedRomanNumeralList();
      // Filling unsorted list and sorted list
      fillLists(fileName, unsortedList, sortedList);
      // Creating GUI object and initialize a simple layout
      // Showing GUI with 3 columns which are unsorted Roman numeral, unsorted Arabic
      // numbers and sorted Arabic numbers
           new RomanNumeralGUI(unsortedList, sortedList);
      

   }

   /**
    * Fill Roman numerals from the text file to unsorted list and sorted list
    * 
    * @param fileName     The text file to be read
    * @param unsortedList The unsorted Linked list to be filled
    * @param sortedList   The sorted Linked list to be filled
    */

   public static void fillLists(String fileName, UnsortedRomanNumeralList unsortedList,
         SortedRomanNumeralList sortedList) {

      // Use TextFileInput to read text file
      TextFileInput in = new TextFileInput(fileName);
      // Reading a line and store in line
      String line = in.readLine();
      // Creating RomaNumeral variable to store roman numeral from the text file
      RomanNumeral roman;

      // Read the text file until there is no line to read and converted to Roman
      // numeral object. Then added to the unsorted list and sorted list
      while (line != null) {
         StringTokenizer myToken = new StringTokenizer(line, ",");
         while (myToken.hasMoreTokens()) {
            roman = new RomanNumeral(myToken.nextToken());

            unsortedList.append(roman);
            sortedList.add(roman);
         }
         line = in.readLine();
      }

   }

}
