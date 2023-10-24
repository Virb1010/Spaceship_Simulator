/* ToggleButton.java 
 * Written By: Vir Bhatia
 * Email: vbhati02@tufts.edu 
 * 
 * This file contains the ToggleButton Class, a toggle button which users can 
 * press to prompt basic actions from the program.
*/

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ToggleButton extends JToggleButton implements ActionListener {
    private String toggledLabel, untoggledLabel, toggledMessage, untoggledMessage;
    private Boolean toggleState = true;

    // Creates a ToggleButton with label label, which prints toggledMessage on 
    // the terminal when toggled, and untoggledMessage when untoggled

    public ToggleButton (String toggledLabel, String untoggledLabel, 
                        String toggledMessage, String untoggledMessage) {
        setText(toggledLabel);
        this.toggledMessage = toggledMessage;
        this.untoggledMessage = untoggledMessage;
        this.toggledLabel = toggledLabel;
        this.untoggledLabel = untoggledLabel;
        addActionListener(this);
    }       

    // handles the behavior of the button for each toggle state
    public void actionPerformed (ActionEvent event) {
        if (toggleState) {
            System.out.println(toggledMessage);
            setText(untoggledLabel);
        } else {
            System.out.println(untoggledMessage);
            setText(toggledLabel);
        }
        toggleState = !toggleState;
    }

    public boolean get_toggleState() {
        return toggleState;
    }
}