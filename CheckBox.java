/* CheckBox.java 
 * Written By: Vir Bhatia
 * Email: vbhati02@tufts.edu 
 * 
 * This file contains the CheckBox Class, a checkbox which users can press to 
 * prompt basic actions from the program.
*/

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckBox extends JCheckBox implements ActionListener {
    private String checkedMessage, uncheckedMessage;

    // Creates a CheckBox with label label, which prints checkedMessage on the 
    // terminal when checked, and uncheckedMessage when unchecked
    public CheckBox (String label, String checkedMessage, 
                    String uncheckedMessage) {
        setText(label);
        this.checkedMessage = checkedMessage;
        this.uncheckedMessage = uncheckedMessage;
        addActionListener(this);
    }       

    public void actionPerformed (ActionEvent event) {
        if (isSelected()) {        
            System.out.println("Checkbox selected: " 
            + checkedMessage);
        } else {
            System.out.println("Checkbox deselected: " 
            + uncheckedMessage);
        }                      
    }
}