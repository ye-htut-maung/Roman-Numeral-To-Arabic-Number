package project4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/**
 * File MenuHandler class implementing ActionListener class which opens the
 * files and read the files and create new GUI
 * 
 * @author Ye Htut Maung
 *
 */
public class FileMenuHandler implements ActionListener {

   JFrame jframe;
   TreeMap <RomanNumeral, Integer> treeList = new TreeMap<>(new RomanNumeralComparator());
   

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



      // Clear out the text areas
      RomanNumeralGUI.SortedRoman.setText("");
      RomanNumeralGUI.sortedNumbers.setText("");
      treeList.clear();

      fillLists(chosenFilePath);

      Set set = treeList.entrySet();
      Iterator i = set.iterator();
      Map.Entry<RomanNumeral, Integer> me;
      
      while (i.hasNext()) {
         me = (Map.Entry)i.next();
         RomanNumeralGUI.SortedRoman.append(me.getKey().getRomanNumeral() + "\n");
         RomanNumeralGUI.sortedNumbers.append(me.getValue().toString() + "\n");
      }

   }

   /**
    * Fill Roman numerals from the text file to unsorted list and sorted list
    * 
    * @param fileName     The text file to be read
    */

   protected void fillLists(String fileName) {

      // Use TextFileInput to read text file
      TextFileInput in = new TextFileInput(fileName);
      // Reading a line and store in line
      String line = in.readLine();
      // Creating RomaNumeral variable to store roman numeral from the text file
      RomanNumeral roman;

      // Read the text file until there is no line to read and converted to Roman
      // numeral object. Then added to the tree List
      while (line != null) {
         StringTokenizer myToken = new StringTokenizer(line, ",");
         while (myToken.hasMoreTokens()) {
            String romanFromFile = myToken.nextToken();
            // if roman numeral is invalid, catch the exception
            try {
               roman = new RomanNumeral(romanFromFile);
               
               treeList.put(roman, roman.getArabicValue());
            } catch (IllegalRomanNumeralException ire) {
               System.out.println(ire);
            }

         }
         line = in.readLine();
      }

   }

}
