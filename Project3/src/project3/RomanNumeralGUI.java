package project3;

import javax.swing.*;
import java.awt.*;

/**
 * The GUI of Roman numeral to Arabic numeral
 * 
 * @author Ye Htut Maung
 *
 */

public class RomanNumeralGUI extends JFrame {

   // Declaring menuBar which includes File and Convert menu

   static JMenuBar menuBar;
   protected static Container myContentPane;
   protected static TextArea myOriginalRoman;
   protected static TextArea unsortedNumbers;
   protected static TextArea sortedNumbers;

   /**
    * Constructor - Creating a User Interface
    */

   public RomanNumeralGUI() {
      setSize(600, 400);
      setLocation(100, 100);
      setTitle("Roman Numeral");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      // Creating Menu Bar
      menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      // Adding File Menu
      createFileMenu();
      // Adding Convert Menu
      createConvertMenu();

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

      setLayout(new GridLayout(1, 3));
      setVisible(true);

   }

   /**
    * Creating the File Menu which has Open MenuItem which opens the files and Quit
    * MenuItem which closes the GUI
    */
   private void createFileMenu() {

      JMenuItem item;
      JMenu fileMenu = new JMenu("File");
      FileMenuHandler fmh = new FileMenuHandler(this);

      item = new JMenuItem("Open");
      item.addActionListener(fmh);
      fileMenu.add(item);

      fileMenu.addSeparator();

      item = new JMenuItem("Quit");
      item.addActionListener(fmh);
      fileMenu.add(item);

      menuBar.add(fileMenu);

   }

   /**
    * Creating the Convert Menu which has Roman to Arabic Menu item which convert
    * Roman Numeral to Arabic Number
    */

   private void createConvertMenu() {

      JMenuItem item;
      JMenu editMenu = new JMenu("Convert");
      ConvertMenuHandler cmh = new ConvertMenuHandler(this);

      item = new JMenuItem("Roman to Arabic");
      item.addActionListener(cmh);
      editMenu.add(item);

      menuBar.add(editMenu);

   }

}
