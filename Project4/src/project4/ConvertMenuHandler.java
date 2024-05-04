package project4;

import java.awt.event.*;
import javax.swing.*;

/**
 * Creating Convert Menu Handler that convert from Roman Numeral to Arabic Numbers
 * @author Ye Htut Maung
 *
 */

public class ConvertMenuHandler implements ActionListener {

   JFrame jframe;

   public ConvertMenuHandler(JFrame jf) {
      jframe = jf;
   }
   /**
    * If the event name is equal to Roman to Arabic, then, convert Roman Numeral to Arabic Numbers
    * @param event
    */

   public void actionPerformed(ActionEvent event) {

      String menuName;
      menuName = event.getActionCommand();

      if (menuName.equals("Roman to Arabic")) {
         convertRomanNumeral();
      }

   }
   
   /**
    * Convert Roman to Arabic number
    * asking user to enter roman numeral and convert the arabic number
    * if the input is not a roman numeral, then print exception message on console
    */

   private void convertRomanNumeral() {
      RomanNumeral roman;
      String romanStr = JOptionPane.showInputDialog(null, "Enter a Roman Numeral");
      try {
         roman = new RomanNumeral(romanStr);
         JOptionPane.showMessageDialog(null, roman.toString());
      } catch (IllegalRomanNumeralException ire) {
         System.out.println(ire);
      }

   }

}
