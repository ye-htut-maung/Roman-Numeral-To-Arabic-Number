package project3;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

/**
 * File MenuHandler class implementing ActionListener class which opens the
 * files and read the files and create new GUI
 * 
 * @author Ye Htut Maung
 *
 */
public class FileMenuHandler implements ActionListener {

   JFrame jframe;
   // Creating an unsorted list
   UnsortedRomanNumeralList unsortedList = new UnsortedRomanNumeralList();
   // Creating a sorted list
   SortedRomanNumeralList sortedList = new SortedRomanNumeralList();

   public FileMenuHandler(JFrame jf) {
      jframe = jf;
   }

   /**
    * Invoked when an action occurs If the event name is equal to open, then open
    * the file If the event name is equal to quit, then exit the GUI
    * 
    * @param event
    */

   public void actionPerformed(ActionEvent event) {
      String menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("Open")) {
         openFile();

      } else if (menuName.equals("Quit")) {
         System.exit(0);
      }
   }

   /**
    * Open file and read the file and then show on GUI
    */

   private void openFile() {
      JFileChooser chooser = new JFileChooser();
      int status;

      status = chooser.showOpenDialog(null);
      if (status == JFileChooser.APPROVE_OPTION) {
         readSource(chooser.getSelectedFile());
      } else {
         JOptionPane.showMessageDialog(null, "Open File dialog canceled");
      }

   }

   /**
    * Read the chosen File and creating list and show on GUI
    * 
    * @param chosenFile
    */

   private void readSource(File chosenFile) {
      String chosenFilePath = chosenFile.getAbsolutePath();

      // Clear out the two lists
      unsortedList.first = new RomanNumeralListNode();
      unsortedList.last = unsortedList.first;
      unsortedList.length = 0;
      sortedList.first = new RomanNumeralListNode();
      sortedList.last = sortedList.first;
      sortedList.length = 0;

      // Clear out the text areas
      RomanNumeralGUI.myOriginalRoman.setText("");
      RomanNumeralGUI.unsortedNumbers.setText("");
      RomanNumeralGUI.sortedNumbers.setText("");

      fillLists(chosenFilePath, unsortedList, sortedList);

      // pointer node of unsorted list
      RomanNumeralListNode unsortedPointer = unsortedList.first.next;

      // adding unsorted roman numeral and arabic numbers to GUI
      while (unsortedPointer != null) {
         RomanNumeralGUI.myOriginalRoman.append(unsortedPointer.data.getRomanNumeral() + "\n");
         RomanNumeralGUI.unsortedNumbers.append(unsortedPointer.data.getArabicValue() + "\n");
         unsortedPointer = unsortedPointer.next;
      }

      // pointer node of sorted list
      RomanNumeralListNode sortedPointer = sortedList.first.next;

      // adding sorted arabic numbers to GUI
      while (sortedPointer != null) {
         RomanNumeralGUI.sortedNumbers.append(sortedPointer.data.getArabicValue() + "\n");
         sortedPointer = sortedPointer.next;
      }

   }

   /**
    * Fill Roman numerals from the text file to unsorted list and sorted list
    * 
    * @param fileName     The text file to be read
    * @param unsortedList The unsorted Linked list to be filled
    * @param sortedList   The sorted Linked list to be filled
    */

   protected void fillLists(String fileName, UnsortedRomanNumeralList unsortedList, SortedRomanNumeralList sortedList) {

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
            String romanFromFile = myToken.nextToken();
            // if roman numeral is invalid, catch the exception
            try {
               roman = new RomanNumeral(romanFromFile);

               unsortedList.append(roman);
               sortedList.add(roman);
            } catch (IllegalRomanNumeralException ire) {
               System.out.println(ire);
            }

         }
         line = in.readLine();
      }

   }

}
